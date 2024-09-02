package objektwerks

import scala.collection.mutable

class Invalidations:
  type Field = String
  type Message = String

  private val invalidFields = mutable.Map[Field, Message]()

  def isEmpty: Boolean = invalidFields.isEmpty

  def count: Int = invalidFields.size

  def add(field: Field, message: Message): Unit = invalidFields += field -> message

  def get(field: Field): Option[Message] = invalidFields.get(field)

  def asList: List[String] = invalidFields.map { (_, message) => s"$message" }.toList

  def asMap: Map[Field, Message] = invalidFields.toMap

  def asString: String = asList.mkString(",")