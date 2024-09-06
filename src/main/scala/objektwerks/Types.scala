package objektwerks

object Types:
  opaque type Name <: String = String
  object Name:
    def apply(value: String): Name = value

  opaque type Age <: Int = Int
  object Age:
    def apply(value: Int): Age = value

  opaque type Field = String
  object Field:
    def apply(value: String): Field = value

  opaque type Message = String
  object Message:
    def apply(value: String): Message = value