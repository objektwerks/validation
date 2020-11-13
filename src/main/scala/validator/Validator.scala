package validator

trait Validator[E, T] {
  def validate(entity: T): Either[E, T]
}