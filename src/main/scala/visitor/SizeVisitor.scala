package visitor

class SizeVisitor extends Visitor {
  private var size = 0
  def getSize(): Int = {
    size
  }

  override def visit(file: File): Unit = {
    size += file.getSize()
  }

  override def visit(directory: Directory): Unit = {
    val it = directory.iterator()
    while (it.hasNext()) {
      val entry = it.next()
      entry.accept(this)
    }
  }

}
