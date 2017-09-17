package data

case class Field(sizeX: Int, sizeY: Int) {


  def controlPresencePositionOnFiled(position: Position): Boolean = {
    if (position.coordX < sizeX && position.coordX >= 0 && position.coordY < sizeY && position.coordY >= 0) true
    else false
  }


}
