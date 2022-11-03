package interpreter.language

import java.util
import scala.util.control.Breaks.{break, breakable}

// <command list> ::= <command>* end
class CommandListNode extends Node {
  private val list = new util.ArrayList[Node]()

  override def parse(context: Context): Unit = {
    breakable {
      while (true) {
        if (context.getCurrentToken() == null) {
          throw new ParseException("Missing 'end'")
        } else if (context.getCurrentToken().equals("end")) {
          context.skipToken("end")
          break
        } else {
          val commandNode = new CommandNode()
          commandNode.parse(context)
          list.add(commandNode)
        }
      }
    }
  }

  override def execute(): Unit = {
    val it = list.iterator()
    while (it.hasNext()) {
      it.next().execute()
    }
  }

  override def toString: String = list.toString

}
