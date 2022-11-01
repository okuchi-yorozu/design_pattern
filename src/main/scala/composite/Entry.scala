package composite

trait Entry {
  var parent: Entry = null

  def getName(): String
  def getSize(): Int
  def add(entry: Entry): Entry = {
    throw new FileTreatmentException()
  }
  def printList(): Unit = printList("")
  def printList(prefix: String): Unit
  override def toString(): String = {
    getName() + " (" + getSize() + ")"
  }
  def getFullName(): String = {
    val fullname = new StringBuffer()
    var entry = this
    do {
      fullname.insert(0, "/" + entry.getName())
      entry = entry.parent
    } while (entry != null)
    fullname.toString()
  }
}
