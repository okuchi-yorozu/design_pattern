package builder

trait Builder {
  private var initialized = false

  def makeTitle(title: String): Unit = {
    if (!initialized) {
      buildTitle(title)
      initialized = true
    }
  }

  def makeString(str: String): Unit = {
    if (initialized) {
      buildString(str)
    }
  }

  def makeItems(items: List[String]): Unit = {
    if (initialized) {
      buildItems(items)
    }
  }

  def close(): Unit = {
    if (initialized) {
      buildDone()
    }
  }

  protected def buildTitle(title: String): Unit

  protected def buildString(str: String): Unit

  protected def buildItems(items: List[String]): Unit

  protected def buildDone(): Unit
}
