package validator

trait Validator[E, T] {
  def validate(entity: T): Either[E, T]
}

def validate[E, T](entity: T)(using validator: Validator[E, T]): Either[E, T] = validator.validate(entity)