package adapter.inherit

import adapter.{Banner, Print}

class PrintBanner(string: String) extends Banner(string) with Print {
  override def printWeak(): Unit = showWithParen()

  override def printStrong(): Unit = showWithAster()
}
