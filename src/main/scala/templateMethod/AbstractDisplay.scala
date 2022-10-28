package templateMethod

trait AbstractDisplay {
  def open(): Unit

  def print(): Unit

  def close(): Unit

  final def display(): Unit = {
    open()
    for (_ <- 1 to 5) {
      print()
    }
    close()
  }

}
