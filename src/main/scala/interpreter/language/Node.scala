package interpreter.language

trait Node extends Executor {
  def parse(context: Context): Unit

}
