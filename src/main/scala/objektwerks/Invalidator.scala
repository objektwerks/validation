package objektwerks

import scala.collection.mutable

import Types.*

final class Invalidator:
  private val invalidations = mutable.Map[Field, Message]()

  private def add(field: Field, message: Message): Invalidator =
    invalidations += field -> message
    this

  def isValid: Boolean = invalidations.isEmpty

  def isInvalid: Boolean = !invalidations.isEmpty

  def count: Int = invalidations.size

  def asList: List[String] = invalidations.map { (field, message) => s"$field $message" }.toList

  def asMap: Map[Field, Message] = invalidations.toMap

  def asString: String =
    val sb = StringBuilder()
    asList.foreach(s =>
      sb.addAll(s)
      sb.addOne(',')
    )
    if sb.nonEmpty then sb.substring(0, sb.length() - 1)
    else ""

  def invalidate(isInvalidExpr: Boolean)(field: Field, message: Message): Invalidator =
    if isInvalidExpr then add(field, message)
    else this

  def invalidate(isInvalidFn: () => Boolean)(field: Field, message: Message): Invalidator =
    if isInvalidFn() then add(field, message)
    else this