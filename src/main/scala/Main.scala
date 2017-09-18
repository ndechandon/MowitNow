
import data.{EnumOrientation, Field, Mower}
import service.MowerBuilder
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {

    val mowerBuilder = MowerBuilder()
    var line = ""
    while ( {
      line = StdIn.readLine();
      line != null
    }) {

      Commandes.matchLine(line, mowerBuilder)

      if (mowerBuilder.completed()) {
        val mower = mowerBuilder.build()
        Commandes.move(mower)
        mowerBuilder.clean()
      }
    }
  }

}
