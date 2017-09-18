package data

object EnumOrientation extends Enumeration {

  val N, E, S, W = Value


  def turnOrientationOnLeft(actualOrientation: EnumOrientation.Value): EnumOrientation.Value = {
    val id =(actualOrientation.id - 1) % EnumOrientation.maxId

    if (id < 0) EnumOrientation.W
    else EnumOrientation.apply(id)
  }

  def turnOrientationOnRight(actualOrientation: EnumOrientation.Value): EnumOrientation.Value = {
     EnumOrientation.apply((actualOrientation.id + 1) % EnumOrientation.maxId)
  }
}

case class EnumOrientation(orientation: EnumOrientation.Value) {

  override def toString: String = {
  this.orientation.toString
  }

}

