package interpreter.language

import java.util.StringTokenizer

class Context(text: String) extends ExecutorFactory {
  private var factory: ExecutorFactory = null
  private val tokenizer: StringTokenizer = new StringTokenizer(text)
  private var currentToken: String = null

  nextToken()

  def nextToken(): String = {
    if (tokenizer.hasMoreTokens()) {
      currentToken = tokenizer.nextToken()
    } else {
      currentToken = null
    }
    currentToken
  }

  def getCurrentToken(): String = {
    currentToken
  }

  def skipToken(token: String): Unit = {
    if(!token.equals(currentToken)) {
      throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.")
    }
    nextToken()
  }

  def currentNumber(): Int = {
    var number = 0
    try {
      number = Integer.parseInt(currentToken)
    } catch {
      case e: NumberFormatException => throw new ParseException("Warning: " + e)
    }
    number
  }

  def setExecutorFactory(factory: ExecutorFactory): Unit = {
    this.factory = factory
  }

  override def createExecutor(name: String): Executor = factory.createExecutor(name)
}
