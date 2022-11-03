package command.drawer

import command.command.Command

import java.awt.Point

class DrawCommand(protected val drawable: Drawable, private val position: Point) extends Command {
  override def execute(): Unit = drawable.draw(position.x, position.y)

}
