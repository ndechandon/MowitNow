

import data.EnumOrientation
import org.scalatest.{FlatSpec, Matchers}


class OrientationSpec extends FlatSpec with Matchers {

  "A direction " should "turn full left" in {
    var orientation = EnumOrientation.N

    orientation = EnumOrientation.turnOrientationOnLeft(orientation)
    orientation.id shouldBe 3
    orientation = EnumOrientation.turnOrientationOnLeft(orientation)
    orientation.id shouldBe 2
    orientation = EnumOrientation.turnOrientationOnLeft(orientation)
    orientation.id shouldBe 1
    orientation = EnumOrientation.turnOrientationOnLeft(orientation)
    orientation.id shouldBe 0
    orientation = EnumOrientation.turnOrientationOnLeft(orientation)
    orientation.id shouldBe 3

  }

  "A direction" should "turn full Right" in {
    var orientation = EnumOrientation.N

    orientation = EnumOrientation.turnOrientationOnRight(orientation)
    orientation.id shouldBe 1
    orientation = EnumOrientation.turnOrientationOnRight(orientation)
    orientation.id shouldBe 2
    orientation = EnumOrientation.turnOrientationOnRight(orientation)
    orientation.id shouldBe 3
    orientation = EnumOrientation.turnOrientationOnRight(orientation)
    orientation.id shouldBe 0
    orientation = EnumOrientation.turnOrientationOnRight(orientation)
    orientation.id shouldBe 1
  }
}
