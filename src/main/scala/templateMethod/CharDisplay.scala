package templateMethod

class CharDisplay(private val ch: Char) extends AbstractDisplay {
  override def open(): Unit = Predef.print("<<")
  override def print(): Unit = println(ch)
  override def close(): Unit = println(">>")
}
