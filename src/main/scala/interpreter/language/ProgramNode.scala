package interpreter.language

// <program> ::= program <command list>
class ProgramNode extends Node {
  private var commandListNode: Node = null

  override def parse(context: Context): Unit = {
    context.skipToken("program")
    commandListNode = new CommandListNode()
    commandListNode.parse(context)
  }

  override def execute(): Unit = {
    commandListNode.execute()
  }

  override def toString: String = "[program " + commandListNode + "]"
}
