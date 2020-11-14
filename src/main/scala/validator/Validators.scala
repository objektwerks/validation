package validator

trait Validators[E, T] {
  def validates(entities: Seq[T]): Seq[Either[E, T]]
}

def validates[E, T](entities: Seq[T])(using validators: Validators[E, T], validator: Validator[E, T]): Seq[Either[E, T]] = 
  entities.map { entity => validator.validate(entity) }