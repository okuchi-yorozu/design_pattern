package command.command

import java.util

class MacroCommand extends Command {
  private val commands: util.Stack[Command] = new util.Stack[Command]()

  override def execute(): Unit = {
    val it = commands.iterator()
    while (it.hasNext()) {
      it.next().execute()
    }
  }

  def append(cmd: Command): Unit = {
    if (cmd != this) {
      commands.push(cmd)
    }
  }

  def undo(): Unit = {
    if(!commands.empty()) {
      commands.pop()
    }
  }

  def clear(): Unit = {
    commands.clear()
  }
}
