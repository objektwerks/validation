package validator

trait EntitiesValidator[R, E, T] {
  def validate(entities: Seq[R]): Seq[Either[E, T]]
}

def validateEntities[R, E, T](entities: Seq[R])
  (using entitiesValidator: EntitiesValidator[R, E, T])
  (using entityValidator: EntityValidator[R, E, T]): Seq[Either[E, T]] = entities.map { entity => entityValidator.validate(entity) }