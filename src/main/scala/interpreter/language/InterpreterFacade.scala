package interpreter.language

class InterpreterFacade(private val factory: ExecutorFactory) extends Executor {
  private var context: Context = null
  private var programNode: Node = null

  def parse(text: String): Boolean = {
    var ok = true
    this.context = new Context(text)
    this.context.setExecutorFactory(factory)
    this.programNode = new ProgramNode()
    try {
      programNode.parse(context)
      println(programNode.toString)
    } catch {
      case e: ParseException => {
        e.printStackTrace()
        ok = false
      }
    }
    ok
  }

  override def execute(): Unit = {
    try {
      programNode.execute()
    } catch {
      case e: ExecuteException => e.printStackTrace()
    }
  }
}
