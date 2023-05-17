package objektwerks

import scala.collection.mutable

object Validations:
  type Field = String
  type Message = String

class Validations:
  import Validations.*

  private val map = mutable.HashMap[Field, Message]()

  def isValid: Boolean = map.size == 0

  def add(field: Field, message: Message): Unit = map += field -> message

  def get(field: Field): Option[Message] = map.get(field)