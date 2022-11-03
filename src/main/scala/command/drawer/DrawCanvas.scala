package command.drawer

import command.command.{ColorCommand, MacroCommand}

import java.awt.{Canvas, Color, Graphics}

class DrawCanvas(width: Int, height: Int, history: MacroCommand) extends Canvas with Drawable {
  private var color: Color = null
  private var radius: Int = 0

  setSize(width, height)
  setBackground(Color.white)
  init()

  override def init(): Unit = {
    color = Color.red
    radius = 6
    history.append(new ColorCommand(this, color))
  }

  override def setColor(color: Color): Unit = this.color = color

  override def paint(g: Graphics): Unit = {
    history.execute()
  }

  def draw(x: Int, y: Int): Unit = {
    val g = getGraphics()
    g.setColor(color)
    g.fillOval(x - radius, y - radius, radius * 2, radius * 2)
  }
}
