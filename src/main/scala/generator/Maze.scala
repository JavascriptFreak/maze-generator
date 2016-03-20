package generator

import scala.util.Random

/**
 * Represents a square maze with predefined size
 * @param size Width and height of the maze
 */
class Maze( size: Int ) extends TMaze {

  /**
   * Stores information about already used coordinates
   */
  private var memory: Set[Point] = Set()

  /**
   * @param x X coordinate
   * @param y Y coordinate
   * @return Information whether a cell at passed coordinates is filled
   */
  private def isFilled( x: Int, y: Int ): Boolean = memory(Point(x,y))

  /**
   * @param x X coordinate
   * @param y Y coordinate
   * @return Information whether point at passed coordinates is on the board
   */
  private def isOnBoard( x: Int, y: Int ): Boolean = x >= 0 && x < size && y >= 0 && y < size

  /**
   * @param x X coordinate
   * @param y Y coordinate
   * @return Information whether a cell can be placed at passed coordinates
   */
  private def isPossible( x: Int, y: Int ): Boolean = isOnBoard(x, y) && !isFilled(x, y)

  /**
   * @param x X coordinate
   * @param y Y coordinate
   * @return List of all directions from passed point (above, right, below, left)
   */
  private def getAllDirections(x: Int, y: Int): List[(Int, Int)] = List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))

  /**
   * Generates a random maze
   * @param x X coordinate
   * @param y Y coordinate
   * @return A random maze as a list like structure
   */
  def generate( x: Int = 0, y: Int = 0 ): CellDef = {

    if(!isPossible(x, y)) CellNone()

    else {

      memory += Point(x, y)

      val t: List[(Int, Int)] = Random.shuffle(getAllDirections(x, y))

      CellSome(x, y, t map { case (a,b) => generate(a, b) })

    }

  }


}
