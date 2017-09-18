import data.{EnumOrientation, Field, Mower, Position}
import exceptions.CreationImpossibleException
import org.scalatest.{FlatSpec, Matchers}
import service.MowerBuilder

class MowerBuilderSpeextends extends FlatSpec with Matchers {


  "A complet mowerBluider" should "return true" in {
    val mowerBuilder= MowerBuilder(Some(Field(4,4)), Some(Position(1,1,EnumOrientation.N)), Some("AAA"))
    mowerBuilder.completed() shouldEqual true
  }

  "A incomplet mowerBluider" should "return false" in {
    val mowerBuilder= MowerBuilder(None, Some(Position(1,1,EnumOrientation.N)), Some("AAA"))
    mowerBuilder.completed() shouldEqual false
  }

  "A complet build" should "return mower" in {
    val mowerBuilder= MowerBuilder(Some(Field(4,4)), Some(Position(1,1,EnumOrientation.N)), Some("AAA"))
    mowerBuilder.build() shouldEqual Mower(Field(4,4),Position(1,1,EnumOrientation.N),"AAA")
  }
  "A invalide build" should "return mower" in {
    val mowerBuilder= MowerBuilder(Some(Field(4,4)), Some(Position(6,1,EnumOrientation.N)), Some("AAA"))
    an [CreationImpossibleException] should be thrownBy mowerBuilder.build()
  }




}
