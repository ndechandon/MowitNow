package data

case class Position(coordX: Int, coordY: Int, orientation: EnumOrientation.Value) {

  override def toString: String = {
    (s"$coordX $coordY $orientation")
  }

  def increaseX(): Position = {
    Position(coordX + 1, coordY, orientation)
  }

  def increaseY(): Position = {
    Position(coordX, coordY + 1, orientation)
  }

  def decreaseX(): Position = {
    Position(coordX - 1, coordY, orientation)
  }

  def decreaseY(): Position = {
    Position(coordX, coordY - 1, orientation)
  }
}
