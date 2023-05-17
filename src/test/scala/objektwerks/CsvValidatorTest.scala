package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Validators.*

class CsvValidatorTest extends AnyFunSuite with Matchers:
  test("valid") {
    val row = Row( Column("Fred Flintstone"), Column("28") )
    val rows = Rows( row )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    validatedPerson.isRight shouldBe true
  }

  test("invalid") {
    val row = Row( Column("Fred Flintstone"), Column("0") )
    val rows = Rows( row )
    val csv = Csv( rows )
    val validatedPerson = validateEntity( csv )
    validatedPerson.isLeft shouldBe true
  }