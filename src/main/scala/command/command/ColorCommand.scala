package command.command

import command.drawer.Drawable

import java.awt.Color

class ColorCommand(protected val drawable: Drawable, private val color: Color) extends Command {
  override def execute(): Unit = drawable.setColor(color)
}
