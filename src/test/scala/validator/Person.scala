package validator

import scala.util.Try

final case class Person(name: String, age: Int)

given PersonValidator as Validator[Throwable, Person] {
  def validate(entity: Person): Either[Throwable, Person] = {
    Try {
      require(entity.name.nonEmpty, s"${entity.name} is empty.")
      require(entity.age > 0, s"${entity.age} less than 1")
      Person(entity.name, entity.age)
    }.toEither
  }
}

given PersonValidators as Validators[Throwable, Person] {
  def validates(entities: Seq[Person]): Seq[Either[Throwable, Person]] = {
    entities.map { entity =>
      Try {
        require(entity.name.nonEmpty, s"${entity.name} is empty.")
        require(entity.age > 0, s"${entity.age} less than 1")
        Person(entity.name, entity.age)
      }.toEither
    }
  }
}