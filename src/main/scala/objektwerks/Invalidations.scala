package objektwerks

import scala.collection.mutable

class Invalidations:
  type Field = String
  type Message = String

  private val invalidFields = mutable.Map[Field, Message]()

  private def add(field: Field, message: Message): Invalidations =
    invalidFields += field -> message
    this

  def isEmpty: Boolean = invalidFields.isEmpty

  def count: Int = invalidFields.size

  def get(field: Field): Option[Message] = invalidFields.get(field)

  def asList: List[String] = invalidFields.map { (_, message) => s"$message" }.toList

  def asMap: Map[Field, Message] = invalidFields.toMap

  def asString: String = asList.mkString(",")

  def invalidate(expression: Boolean)(field: Field, message: Message): Invalidations =
    if expression then add(field, message)
    else this

  def invalidate(fn: () => Boolean)(field: Field, message: Message): Invalidations =
    if fn() then add(field, message)
    else this