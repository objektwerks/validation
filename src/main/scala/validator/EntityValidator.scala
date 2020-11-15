package validator

trait EntityValidator[E, T] {
  def validate(entity: T): Either[E, T]
}

def validateEntity[E, T](entity: T)(using entityValidator: EntityValidator[E, T]): Either[E, T] = entityValidator.validate(entity)