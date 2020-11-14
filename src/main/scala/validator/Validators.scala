package validator

trait Validators[E, T] {
  def validate(entities: Seq[T]): Seq[Either[E, T]]
}

def validateEntities[E, T](entities: Seq[T])(using validators: Validators[E, T], validator: Validator[E, T]): Seq[Either[E, T]] = 
  entities.map { entity => validator.validate(entity) }