

import data.{EnumOrientation, Field, Position, Mower}
import service.MowerBuilder

object Commandes {

  def matchLine(info: String, mowerBuilder: MowerBuilder): Unit = {

    val PatternPosition = """^(\d) (\d) (N|S|W|E)$""".r
    val PatternCommande = """^([A|D|G]+)$""".r
    val PatternTerrain = """^(\d) (\d)$""".r

    info match {
      case PatternPosition(xPosition, yPosition, direction) => mowerBuilder.withPosition(Position(xPosition.toInt, yPosition.toInt,
        EnumOrientation.withName(direction)))
      case PatternTerrain(xSize, ySize) => mowerBuilder.withField(Field(xSize.toInt, ySize.toInt))
      case PatternCommande(commande) => mowerBuilder.withorder(commande)
      case _ => println("Ligne invalide")
    }
  }

  def move(mower: Mower) = {
    var position = mower.position
    mower.order.foreach { x =>
      //Calcul new position
      val newposition = calculfutherStep(position, x)
      //control presence new position
      if (mower.field.controlPresencePositionOnFiled(newposition)) {
        position = newposition
      }
    }
    println(position)
  }

  def calculfutherStep(position: Position, letter: Char): Position = {
    letter match {
      case 'A' => calculfutherStepDependingOrientation(position)
      case 'D' => Position(position.coordX, position.coordY, EnumOrientation.turnOrientationOnRight(position.orientation))
      case 'G' => Position(position.coordX, position.coordY, EnumOrientation.turnOrientationOnLeft(position.orientation))
    }
  }

  private def calculfutherStepDependingOrientation(position: Position): Position = {
    position.orientation match {
      case EnumOrientation.N => position.increaseY()
      case EnumOrientation.S => position.decreaseY()
      case EnumOrientation.E => position.increaseX()
      case EnumOrientation.W => position.decreaseX()
    }
  }
}




