package com.simplesys.io
package processing

/**
 * Processor that repeats until empty or maxRepetitions
 */
private[processing] class RepeatUntilEmpty(private[this] val maxRepetitions:Long, processorFactory: ProcessorFactory, private[this] val ProcessorAPIs: ProcessorAPI[_]*) {
  private[this] def closeableIteratorOps = new CloseableIteratorOps(new CloseableIterator[Long] {
    private[this] var index = 0L
    def hasNext = index < maxRepetitions && ProcessorAPIs.exists{api =>
      api.iterator.hasNext
    }
    def next = {
      index += 1
      index - 1
    }
    def doClose = Nil
  })

  def foreach[U](f: Long => U) = closeableIteratorOps.iter foreach f
  def flatMap[U](f: Long => Processor[U]) = processorFactory[LongTraversable[U]](Some(LongTraversable(processorFactory.resourceContext, closeableIteratorOps.flatMap(i =>f(i).init.execute))))
  def map[U](f: Long => U) = processorFactory[LongTraversable[U]](Some(LongTraversable(processorFactory.resourceContext, closeableIteratorOps map f)))
}
