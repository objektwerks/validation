package validator

import munit._

class CsvValidatorTest extends FunSuite {
  test("valid") {
    val columns = Seq("Fred Flintstone", "28")
    val rows = Seq( columns )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    assert( validatedPerson.isRight )
  }

  test("invalid") {
    val columns = Seq("Fred Flintstone", "0")
    val rows = Seq( columns )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    assert( validatedPerson.isLeft )
  }
}