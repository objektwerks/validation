package validator

import scala.util.Try

final case class Person(name: String, age: Int)

extension (person: Person) {
  def validateName: Unit = require(person.name.nonEmpty, "Name is empty.")
  def validateAge: Unit = require(person.age > 0, s"Age of ${person.age} is less than 1.")
}

given PersonValidator as Validator[Throwable, Person] {
  def validate(person: Person): Either[Throwable, Person] =
    Try {
      person.validateName
      person.validateAge
      Person(person.name, person.age)
    }.toEither
}

given PersonValidators as Validators[Throwable, Person] {
  def validates(persons: Seq[Person]): Seq[Either[Throwable, Person]] =
    persons.map { person =>
      Try {
        person.validateName
        person.validateAge
        Person(person.name, person.age)
      }.toEither
    }
}