package generator

/**
 * Defines all public methods for Maze class
 */
trait TMaze {

  def generate( x: Int = 0, y: Int = 0 ): CellDef

}
