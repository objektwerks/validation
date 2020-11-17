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

given PersonValidator as EntityValidator[Person, Throwable, Person] {
  def validate(person: Person): Either[Throwable, Person] = Try( person.validate ).toEither
}

given PersonsValidator as EntitiesValidator[Person, Throwable, Person] {
  def validate(persons: Seq[Person]): Seq[Either[Throwable, Person]] = persons.map { person => Try( person.validate ).toEither }
}

given CsvValidator as EntityValidator[Array[String], Throwable, Person] {
  def validate(csv: Array[String]): Either[Throwable, Person] =
    Try { 
      require(csv.length == 2, "Csv length != 2.")
      val name = csv(0)
      val age = Try( csv(1).toInt ).getOrElse(0)
      Person(name, age).validate
    }.toEither
}

given JsonValidator as EntityValidator[String, Throwable, Person] {
  def validate(json: String): Either[Throwable, Person] =
    import ujson._
    Try {
      val jsonValue = ujson.read(json)
      val name = jsonValue("name").str
      val age = jsonValue("age").num.toInt
      Person(name, age).validate
    }.toEither
}