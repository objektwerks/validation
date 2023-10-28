package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class InvalidationsTest extends AnyFunSuite with Matchers:
  test("valid"):
    val person = Person("Fred Flintsone", 28)
    val invalidations = person.invalidations
    invalidations.isEmpty shouldBe true

  test("invalid"):
    val person = Person("", 0)
    val invalidations = person.invalidations
    invalidations.isEmpty shouldBe false
    invalidations.get("name").nonEmpty shouldBe true
    invalidations.get("age").nonEmpty shouldBe true
    invalidations.collect.size shouldBe 2