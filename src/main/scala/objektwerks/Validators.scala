package objektwerks

object Validators:
  trait EntityValidator[R, E, T]:
    def validate(entity: R): Either[E, T]

  def validateEntity[R, E, T](entity: R)
    (using entityValidator: EntityValidator[R, E, T]): Either[E, T] = entityValidator.validate(entity)

  trait EntitiesValidator[R, E, T]:
    def validate(entities: Seq[R]): Seq[Either[E, T]]

  def validateEntities[R, E, T](entities: Seq[R])
    (using entitiesValidator: EntitiesValidator[R, E, T])
    (using entityValidator: EntityValidator[R, E, T]): Seq[Either[E, T]] = entities.map { entity => entityValidator.validate(entity) }