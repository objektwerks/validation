package validator

import munit._

class CsvValidatorTest extends FunSuite {
  test("valid") {
    val array = Array("Fred Flintstone", "28")
    val validatedPerson = validateEntity( array )
    assert( validatedPerson.isRight )
  }

  test("invalid") {
    val array = Array("Fred Flintstone", "0")
    val validatedPerson = validateEntity( array )
    assert( validatedPerson.isLeft )
  }
}