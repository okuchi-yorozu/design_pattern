package interpreter.language

trait ExecutorFactory {
  def createExecutor(name: String): Executor
}
