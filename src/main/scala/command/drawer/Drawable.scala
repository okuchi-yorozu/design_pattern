package command.drawer

import java.awt.Color

trait Drawable {
  def init(): Unit
  def draw(x: Int, y: Int): Unit
  def setColor(color: Color): Unit
}
