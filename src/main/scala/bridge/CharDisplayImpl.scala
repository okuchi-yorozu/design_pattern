package bridge

class CharDisplayImpl(private val head: Char, private val body: Char, private val foot: Char) extends DisplayImpl {
  override def rawOpen(): Unit = print(head)

  override def rawPrint(): Unit = print(body)

  override def rawClose(): Unit = println(foot)
}
