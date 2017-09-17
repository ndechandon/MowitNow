import data.{EnumOrientation, Field, Position}
import org.scalatest.{FlatSpec, Matchers}

class Fieldspec extends FlatSpec with Matchers {


  "a valide x and y position" should "return true" in {
    val field = Field(4,4)
    val position = Position(3,0,EnumOrientation.N)
    field.controlPresencePositionOnFiled(position) shouldBe true
  }

  "a invalde x position" should "return false" in {
    val field = Field(4,4)
    val position = Position(6,0,EnumOrientation.N)
    field.controlPresencePositionOnFiled(position) shouldBe false
  }

  "a invalde y position" should "return false" in {
    val field = Field(4,4)
    val position = Position(3,6,EnumOrientation.N)
    field.controlPresencePositionOnFiled(position) shouldBe false
  }
  "a negatif x position" should "return false" in {
    val field = Field(4,4)
    val position = Position(-1,3,EnumOrientation.N)
    field.controlPresencePositionOnFiled(position) shouldBe false
  }
}
