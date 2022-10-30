package bridge

class CountDisplay(impl: DisplayImpl) extends Display(impl) {
  def multiDisplay(times: Int): Unit = {
    open()
    for(_ <- 0 until times) {
      print()
    }
    close()
  }
}
