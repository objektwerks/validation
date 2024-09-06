package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Types.*

final class InvalidatorTest extends AnyFunSuite with Matchers:
  test("valid"):
    val person = Person(Name("Fred Flintsone"), Age(28))
    val invalidations = person.invalidate
    invalidations.isEmpty shouldBe true

  test("invalid"):
    val person = Person(Name(""), Age(0))
    val invalidations = person.invalidate
    invalidations.isNonEmpty shouldBe true
    invalidations.count shouldBe 2

    println( invalidations.asList )
    println( invalidations.asMap )
    println( invalidations.asString )