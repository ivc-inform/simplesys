package com.simplesys.xml.factory

import scala.xml.{TypeSymbol, Text, MetaData, NamespaceBinding, Node}
import com.simplesys.xml.Elem
import scala.xml.factory.NodeFactory
import com.simplesys.log.Logging
import javax.xml.validation.TypeInfoProvider

class NoBindingFactoryAdapter(override val provider: TypeInfoProvider = null) extends FactoryAdapter with NodeFactory[Elem] with Logging {
  /** True.  Every XML node may contain text that the application needs */
  def nodeContainsText(label: String) = true

  /** From NodeFactory.  Constructs an instance of scala.xml.Elem */
  protected def create(pre: String, label: String, attrs: MetaData, scope: NamespaceBinding, children: Seq[Node]): Elem =
    Elem(pre, label, attrs, scope, children.isEmpty, children: _*)

  /** From FactoryAdapter.  Creates a node. never creates the same node twice, using hash-consing. */
  def createNode(pre: String, label: String, attrs: MetaData, scope: NamespaceBinding, children: List[Node]): Elem =
    Elem(pre, label, attrs, scope, children.isEmpty, children: _*)

  def createNode(pre: String, label: String, attrs: MetaData, `type`: TypeSymbol, scope: NamespaceBinding, children: List[Node]): Elem =
    Elem(pre, label, attrs, `type`, scope, children.isEmpty, children: _*)

  /** Creates a text node. */
  def createText(text: String) = Text(text)

  /** Creates a processing instruction. */
  def createProcInstr(target: String, data: String) = makeProcInstr(target, data)
}