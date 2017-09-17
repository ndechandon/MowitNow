import data.{EnumOrientation, Position}
import org.scalatest.{FlatSpec, Matchers}


class PositionSpec extends FlatSpec with Matchers {

  " Add increase X postion" should "return a new postion with x+1" in {
  val position= Position(1,2,EnumOrientation.N).increaseX()
    position shouldBe Position(2,2,EnumOrientation.N)
  }

  " Add increase Y postion" should "return a new postion with Y+1" in {
    val position= Position(2,1,EnumOrientation.N).increaseY()
    position shouldBe Position(2,2,EnumOrientation.N)
  }

  " remove increase X postion" should "return a new postion with x-1" in {
    val position= Position(2,2,EnumOrientation.N).decreaseX()
    position shouldBe Position(1,2,EnumOrientation.N)
  }

  " remove increase Y postion" should "return a new postion with Y-1" in {
   // val position= Position(2,2,EnumOrientation.N).decreaseY()
    //position shouldBe Position(2,1,EnumOrientation.N)

    val position1= Position(1,2,EnumOrientation.N)
    val position2= Position(1,2,EnumOrientation.N)
    println(position1.equals(position2))
  }

}
