package com.simplesys.io.extractor

import java.nio.channels.FileChannel
import java.io.FileInputStream
import com.simplesys.io.nio.SeekableFileChannel
import com.simplesys.io.Adapter

object FileChannelExtractor {
  def unapply(obj:Any):Option[FileChannel] =
    obj match {
    case fin:FileInputStream => Some(fin.getChannel)
    case sfc:SeekableFileChannel => Some(sfc.self)
    case fc:FileChannel => Some(fc)
    case ad:Adapter[_] => unapply(ad.src)
    case _ => None
  }
}
