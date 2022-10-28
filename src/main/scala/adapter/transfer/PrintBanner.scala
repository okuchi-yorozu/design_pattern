package adapter.transfer

import adapter.{Banner, Print}

class PrintBanner(string: String) extends Print {
  private val banner = new Banner(string)

  override def printWeak(): Unit = banner.showWithParen()
  override def printStrong(): Unit = banner.showWithAster()
}
