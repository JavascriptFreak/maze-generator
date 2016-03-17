package generator

import org.scalatest._

import scala.collection.mutable.ListBuffer

/** Class description
  *
  */
class MazeTest extends FlatSpec with Matchers {

  "Maze" should "generate (n * n) fields with different [x,y] location where N is maze constructor parameter " in {

    val size: Int = 3
    val m: Maze = new Maze(size)

    var i: Int = 0
    var l: ListBuffer[Point] = ListBuffer()

    def evaluate(c: CellDef): Unit = c match {

      case CellSome(x, y, conn) =>

        i = i + 1
        l += new Point(x, y)

        evaluate(conn.head)
        evaluate(conn(1))
        evaluate(conn(2))
        evaluate(conn(3))

      case CellNone() =>

    }

    evaluate(m.generate())

    for (
      x <- 0 to size - 1;
      y <- 0 to size - 1
    ) yield assert(l.exists( (p: Point ) => p.x == x && p.y == y ))

    assert(i == size * size)

  }

}
