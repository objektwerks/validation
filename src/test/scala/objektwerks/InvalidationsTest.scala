package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class InvalidationsTest extends AnyFunSuite with Matchers:
  test("valid"):
    val person = Person("Fred Flintsone", 28)
    val invalidations = person.invalidate
    println(s"*** valid: invalidations: ${invalidations.asMap}")
    invalidations.isEmpty shouldBe true

  test("invalid"):
    val person = Person("", 0)
    val invalidations = person.invalidate
    println(s"*** invalid: invalidations: ${invalidations.asMap}")
    invalidations.isNonEmpty shouldBe true
    invalidations.count shouldBe 2
    println( invalidations.asList )
    println( invalidations.asMap )
    println( invalidations.asString )