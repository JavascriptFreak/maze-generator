package generator

import scala.util.Random

/** Class description
  *
  */
class Maze( size: Int ) extends TMaze {

  var memory: Set[Point] = Set()

  private def isFilled( x: Int, y: Int ): Boolean = memory(Point(x,y))

  private def isOnBoard(x: Int, y: Int): Boolean = x >= 0 && x < size && y >= 0 && y < size

  private def isPossible( x: Int, y: Int ): Boolean = isOnBoard(x, y) && !isFilled(x, y)

  private def getAllDirections(x: Int, y: Int): List[(Int, Int)] = List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))

  def generate( x: Int = 0, y: Int = 0 ): CellDef = {

    if(!isPossible(x, y)) CellNone()

    else {

      memory += Point(x, y)

      val t: List[(Int, Int)] = Random.shuffle(getAllDirections(x, y))

      CellSome(x, y, t map { case (a,b) => generate(a, b) })

    }

  }


}
