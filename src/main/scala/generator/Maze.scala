package generator

import scala.util.Random

/** Class description
  *
  */
class Maze( size: Int ) extends TMaze {

  var map: Set[Point] = Set()

  private def isFilled( x: Int, y: Int ): Boolean = !map.exists( (p: Point) => p.x == x && p.y == y )

  private def canMove( x: Int, y: Int ): Boolean = if(x < 0 || x > size - 1 || y < 0 || y > size - 1 || !isFilled(x, y)) false else true

  private def isPossible( x: Int, y: Int ): Boolean = if(canMove(x, y)) true else false

  def generate( x: Int = 0, y: Int = 0 ): CellDef = {

    if(!isPossible(x, y)) CellNone()

    else {

      val t: List[(Int, Int)] = Random.shuffle(List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)))

      map += Point(x, y)

      CellSome(x, y, List(
        generate(t.head._1, t.head._2),
        generate(t(1)._1, t(1)._2),
        generate(t(2)._1, t(2)._2),
        generate(t(3)._1, t(3)._2)
      ))

    }

  }

}
