package validator

import scala.collection.mutable.ArrayBuffer
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

given CsvValidator as EntityValidator[Csv, Throwable, Seq[Person]] {
  def validate(csv: Csv): Either[Throwable, Seq[Person]] =
    Try {
      val persons = ArrayBuffer[Person]()
      for row <- csv.rows
        yield
          val name = row(0)
          val age = Try( row(1).toInt ).getOrElse(0)
          persons.addOne( Person(name, age).validate )
      persons.toSeq
    }.toEither
}

given JsonValidator as EntityValidator[Json, Throwable, Person] {
  def validate(json: Json): Either[Throwable, Person] =
    import ujson._
    Try {
      val value = json.value
      val jsonValue = ujson.read(value)
      val name = jsonValue("name").str
      val age = jsonValue("age").num.toInt
      Person(name, age).validate
    }.toEither
}

given JsonsValidator as EntityValidator[Jsons, Throwable, Seq[Person]] {
  def validate(jsons: Jsons): Either[Throwable, Seq[Person]] =
    import ujson._
    Try {
      val persons = ArrayBuffer[Person]()
      for value <- jsons.values
        yield
          val jsonValue = ujson.read(value)
          val name = jsonValue("name").str
          val age = jsonValue("age").num.toInt
          persons.addOne( Person(name, age).validate )
      persons.toSeq
    }.toEither
}