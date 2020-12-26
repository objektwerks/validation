package validator

import munit._

class CsvValidatorTest extends FunSuite {
  test("valid") {
    val row = Row( Column("Fred Flintstone"), Column("28") )
    val rows = Rows( row )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    assert( validatedPerson.isRight == true )
  }

  test("invalid") {
    val row = Row( Column("Fred Flintstone"), Column("0") )
    val rows = Rows( row )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    assert( validatedPerson.isLeft == true )
  }
}