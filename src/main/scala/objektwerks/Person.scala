package objektwerks

import Person.*
import Types.*
import Validators.*

object Person:
  val nameField = Field("Name")
  val ageField = Field("Age")

  val nameMessage = Message("Name is less than 1 character.")
  val ageMessage = Message("Age is less than 1.")

final case class Person(name: Name, age: Age)

extension (person: Person)
  def validate: Person =
    require(person.name.nonEmpty, nameMessage)
    require(person.age > 0, ageMessage)
    person

  def invalidate: Invalidator =
    Invalidator()
      .invalidate(person.name.isEmpty)(nameField, nameMessage)
      .invalidate(person.age < 1)(ageField, ageMessage)

  def xvalidate: Validator =
    Validator()
      .validate(person.name.nonEmpty)(nameField, Message("Name must be non empty."))
      .validate(person.age > 0)(ageField, Message("Age must be greater than 1."))