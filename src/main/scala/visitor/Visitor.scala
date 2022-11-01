package visitor

trait Visitor {
  def visit(file: File): Unit
  def visit(directory: Directory): Unit
}
