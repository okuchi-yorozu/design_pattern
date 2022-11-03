package interpreter.language

// <repeat command> ::= repeat <number> <command list>
class RepeatCommandNode extends Node {
  private var number: Int = 0
  private var commandListNode: Node = null

  override def parse(context: Context): Unit = {
    context.skipToken("repeat")
    number = context.currentNumber()
    context.nextToken()
    commandListNode = new CommandListNode()
    commandListNode.parse(context)
  }

  override def execute(): Unit = {
    for (_ <- 0 until number) {
      commandListNode.execute()
    }
  }

  override def toString: String = "[repeat " + number + " " + commandListNode + "]"

}
