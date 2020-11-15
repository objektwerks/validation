package validator

import munit._

class EntityValidatorTest extends FunSuite {
  test("validate") {
    val person = Person("Fred Flintsone", 28)
    assert( person.validate == person )
  }

  test("valid") {
    val person = Person("Fred Flintsone", 28)
    val validatedPerson = validateEntity( person )
    assert( validatedPerson.isRight )
  }

  test("invalid") {
    val person = Person("", 0)
    val validatedPerson = validateEntity( person )
    assert( validatedPerson.isLeft )
  }
}