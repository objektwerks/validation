package validator

import scala.util.Try

trait Validator[E, T] {
  def validate(entity: T): Either[E, T]
}