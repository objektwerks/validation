package validator

import munit._

class ValidatorTest extends FunSuite {
  test("validator") {
    val person = Person("Fred Flintsone", 28)
    validate( person ) match {
      case Left(error) => fail(error.getMessage)
      case Right(entity) => assert(entity != null)
    }
  }
}