package objektwerks

import scala.util.Try
import scala.collection.mutable.ArrayBuffer

import ujson.*

import Types.*

object Validators:
  trait EntityValidator[R, E, T]:
    def validate(entity: R): Either[E, T]

  def validateEntity[R, E, T](entity: R)
    (using entityValidator: EntityValidator[R, E, T]): Either[E, T] = entityValidator.validate(entity)

  trait EntitiesValidator[R, E, T]:
    def validate(entities: Seq[R]): Seq[Either[E, T]]

  def validateEntities[R, E, T](entities: Seq[R])
    (using entitiesValidator: EntitiesValidator[R, E, T])
    (using entityValidator: EntityValidator[R, E, T]): Seq[Either[E, T]] = entities.map { entity => entityValidator.validate(entity) }

  given EntityValidator[Person, Throwable, Person] with
    def validate(person: Person): Either[Throwable, Person] = Try( person.validate ).toEither

  given EntitiesValidator[Person, Throwable, Person] with
    def validate(persons: Seq[Person]): Seq[Either[Throwable, Person]] = persons.map { person => Try( person.validate ).toEither }

  given EntityValidator[Csv, Throwable, Seq[Person]] with
    def validate(csv: Csv): Either[Throwable, Seq[Person]] =
      Try:
        val persons = ArrayBuffer[Person]()
        for row <- csv.rows
          yield
            val name = row.head
            val age = Try( row(1).toInt ).getOrElse(0)
            persons.addOne( Person(Name(name), Age(age)).validate )
        persons.toSeq
      .toEither

  given EntityValidator[Json, Throwable, Seq[Person]] with
    def validate(json: Json): Either[Throwable, Seq[Person]] =
      Try:
        val persons = ArrayBuffer[Person]()
        for jsonObject <- json.jsonObjects
          yield
            val jsonValue = ujson.read(jsonObject)
            val name = jsonValue("name").str
            val age = jsonValue("age").num.toInt
            persons.addOne( Person(Name(name), Age(age)).validate )
        persons.toSeq
      .toEither