import org.scalatest.{FlatSpec, Matchers}
import data.{EnumOrientation, Field, Position}
import service.MowerBuilder


class CommandesSpec extends FlatSpec with Matchers {



  " Good ine Position" should "return a tuple with commande and properties" in {
    val mowerBuilder= new MowerBuilder()
    Commandes.matchLine("3 4 N",mowerBuilder)
    mowerBuilder.position shouldBe (Some(Position(3,4,EnumOrientation.N)))
  }

  "Wrong line Position" should "return none " in {
    val mowerBuilder= new MowerBuilder()
    val result = Commandes.matchLine("2 5 G",mowerBuilder)
    mowerBuilder.position shouldBe(None)
  }

  "Good line order" should "return a  tuple with order and properties " in {
    val mowerBuilder= new MowerBuilder()
    val result = Commandes.matchLine("ADGADG",mowerBuilder)
    mowerBuilder.order shouldBe (Some("ADGADG"))

  }

  "Wrong line order" should "return none " in {
    val mowerBuilder= new MowerBuilder()
    val result = Commandes.matchLine("ADGAE",mowerBuilder)
    mowerBuilder.order shouldBe (None)

  }

  " Good ine Field" should "return a tuple with field and properties" in {
    val mowerBuilder= new MowerBuilder()
    val result = Commandes.matchLine("5 8",mowerBuilder)
    mowerBuilder.field shouldBe (Some(Field(5,8)))
  }

  "Wrong line Filed" should "return none" in {
    val mowerBuilder= new MowerBuilder()
    val result = Commandes.matchLine("2 -3",mowerBuilder)
    mowerBuilder.field shouldBe (None)
  }

  "order G" should "return a new position with orientation change" in {
    val position = Position(1,2,EnumOrientation.N)
    Commandes.calculfutherStep(position,'G') shouldEqual  Position(1,2,EnumOrientation.W)
  }

  "order D" should "return a new position with orientation change" in {
    val position = Position(1,2,EnumOrientation.N)
    Commandes.calculfutherStep(position,'D') shouldEqual  Position(1,2,EnumOrientation.E)
  }

  "order A" should "return a new position with x increase" in {
    val position = Position(1,2,EnumOrientation.N)
    Commandes.calculfutherStep(position,'A') shouldEqual  Position(2,2,EnumOrientation.N)
  }

  "order A" should "return a new position with y increase" in {
    val position = Position(1,1,EnumOrientation.E)
    Commandes.calculfutherStep(position,'A') shouldEqual  Position(1,2,EnumOrientation.E)
  }
  "order A" should "return a new position with x decrease" in {
    val position = Position(1,2,EnumOrientation.S)
    Commandes.calculfutherStep(position,'A') shouldEqual  Position(0,2,EnumOrientation.S)
  }
  "order A" should "return a new position with y decrease" in {
    val position = Position(1,2,EnumOrientation.W)
    Commandes.calculfutherStep(position,'A') shouldEqual  Position(1,1,EnumOrientation.W)
  }

}


