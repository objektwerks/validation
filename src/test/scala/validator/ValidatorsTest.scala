package validator

import munit._

class ValidatorsTest extends FunSuite {
  test("validators") {
    val persons = List( Person("Fred Flintsone", 28), Person("Betty Flintsone", 27) )
    validates( persons ) foreach { person => person match {
        case Left(error) => fail(error.getMessage)
        case Right(entity) => assert(entity != null)
      }
    }
  }
}