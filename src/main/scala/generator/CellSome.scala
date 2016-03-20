package generator

/**
 * Defines a single cell in a maze
 * @param x X coordinate
 * @param y Y coordinate
 * @param conn List of cells that a cell instance connects to
 */
case class CellSome( x: Int, y: Int, conn: List[CellDef] ) extends CellDef