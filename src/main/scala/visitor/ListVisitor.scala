package visitor

class ListVisitor extends Visitor {
  private var currentdir = ""

  override def visit(file: File): Unit = println(currentdir + "/" + file)
  override def visit(directory: Directory): Unit = {
    println(currentdir + "/" + directory)
    val savedir = currentdir
    currentdir = currentdir + "/" + directory.getName()
    val it = directory.iterator()
    while (it.hasNext()) {
      val entry = it.next()
      entry.accept(this)
    }
    currentdir = savedir
  }

}
