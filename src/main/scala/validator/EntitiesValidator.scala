package validator

trait EntitiesValidator[E, T] {
  def validate(entities: Seq[T]): Seq[Either[E, T]]
}

def validateEntities[E, T](entities: Seq[T])
  (using entitiesValidator: EntitiesValidator[E, T])
  (using entityValidator: EntityValidator[E, T]): Seq[Either[E, T]] = entities.map { entity => entityValidator.validate(entity) }