package interpreter.language

// <primitive command> ::= go | right | left
class PrimitiveCommandNode extends Node {
  private var name: String = null
  private var executor: Executor = null

  override def parse(context: Context): Unit = {
    name = context.getCurrentToken()
    context.skipToken(name)
    executor = context.createExecutor(name)
//    if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
//      throw new ParseException(name + " is undefined")
//    }
  }

  override def execute(): Unit = {
    if (executor == null) {
      throw new ExecuteException(name + ": is not defined")
    } else {
      executor.execute()
    }
  }

  override def toString: String = name

}
