package bridge

class Display(private val impl: DisplayImpl) {
  def open():Unit = impl.rawOpen()
  def print():Unit = impl.rawPrint()
  def close():Unit = impl.rawClose()

  final def display(): Unit = {
    open()
    print()
    close()
  }
}
