package validator

trait Validators[E, T] {
  def validate(entity: Seq[T]): Seq[Either[E, T]]
}