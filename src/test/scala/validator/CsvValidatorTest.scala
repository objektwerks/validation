package validator

import munit._

class CsvValidatorTest extends FunSuite {
  test("valid") {
    val array = Array("Fred Flintstone", "28")
    val validatedCsv = validateEntity( array )
    assert( validatedCsv.isRight )

    val csv = validatedCsv.toOption.get
    val validPerson = Person.toValidPerson(csv)
    assert( validPerson.isRight )
  }

  test("invalid") {
    val array = Array("Fred Flintstone")
    val validatedCsv = validateEntity( array )
    assert( validatedCsv.isLeft )
  }
}