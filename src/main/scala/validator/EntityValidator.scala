package validator

trait EntityValidator[R, E, T]:
  def validate(entity: R): Either[E, T]

def validateEntity[R, E, T](entity: R)
  (using entityValidator: EntityValidator[R, E, T]): Either[E, T] = entityValidator.validate(entity)