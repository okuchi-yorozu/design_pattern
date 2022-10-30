package abstractFactory.factory

import java.util

abstract class Tray(caption: String) extends Item(caption) {
  protected val tray = new util.ArrayList[Item]()

  def add(item: Item): Unit = tray.add(item)
}
