package validator

import scala.util.Try

final case class Person(name: String, age: Int)

extension (person: Person) {
  def validate: Person = {
    require(person.name.nonEmpty, "Name is empty.")
    require(person.age > 0, s"Age of ${person.age} is less than 1.")
    person
  }
}

given PersonValidator as Validator[Throwable, Person] {
  def validate(person: Person): Either[Throwable, Person] = Try( person.validate ).toEither
}

given PersonValidators as Validators[Throwable, Person] {
  def validate(persons: Seq[Person]): Seq[Either[Throwable, Person]] = persons.map { person => Try( person.validate ).toEither }
}