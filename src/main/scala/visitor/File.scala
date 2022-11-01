package visitor

class File(private val name: String, private val size: Int) extends Entry {
  override def getName(): String = name

  override def getSize(): Int = size

  override def accept(v: Visitor): Unit = v.visit(this)
}
