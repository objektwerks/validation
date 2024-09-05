package objektwerks

import scala.collection.mutable

class Invalidations:
  type Field = String
  type Message = String

  private val invalidations = mutable.Map[Field, Message]()

  private def add(field: Field, message: Message): Invalidations =
    invalidations += field -> message
    this

  def isEmpty: Boolean = invalidations.isEmpty

  def count: Int = invalidations.size

  def get(field: Field): Option[Message] = invalidations.get(field)

  def asList: List[String] = invalidations.map { (_, message) => s"$message" }.toList

  def asMap: Map[Field, Message] = invalidations.toMap

  def asString: String = asList.mkString(",")

  def invalidate(isInvalidExpr: Boolean)(field: Field, message: Message): Invalidations =
    if isInvalidExpr then add(field, message)
    else this

  def invalidate(isInvalidFn: () => Boolean)(field: Field, message: Message): Invalidations =
    if isInvalidFn() then add(field, message)
    else this