package interpreter.language

// <command> ::= <repeat command> | <primitive command>
class CommandNode extends Node {
  private var node: Node = null

  override def parse(context: Context): Unit = {
    if(context.getCurrentToken().equals("repeat")) {
      node = new RepeatCommandNode()
      node.parse(context)
    } else {
      node = new PrimitiveCommandNode()
      node.parse(context)
    }
  }

  override def execute(): Unit = {
    node.execute()
  }

  override def toString: String = node.toString

}
