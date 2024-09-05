package objektwerks

import scala.collection.mutable

opaque type Field = String
object Field:
  def apply(value: String): Field = value

opaque type Message = String
object Message:
  def apply(value: String): Message = value

class Invalidations:
  private val invalidations = mutable.Map[Field, Message]()

  private def add(field: Field, message: Message): Invalidations =
    invalidations += field -> message
    this

  def isEmpty: Boolean = invalidations.isEmpty

  def isNonEmpty: Boolean = !invalidations.isEmpty

  def count: Int = invalidations.size

  def asList: List[String] = invalidations.map { (_, message) => s"$message" }.toList

  def asMap: Map[Field, Message] = invalidations.toMap

  def asString: String = asList.mkString(",")

  def invalidate(isInvalidExpr: Boolean)(field: Field, message: Message): Invalidations =
    if isInvalidExpr then add(field, message)
    else this

  def invalidate(isInvalidFn: () => Boolean)(field: Field, message: Message): Invalidations =
    if isInvalidFn() then add(field, message)
    else this