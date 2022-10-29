package builder

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      usage()
      System.exit(0)
    }

    if (args(0) == "plain") {
      val textbuilder = new TextBuilder()
      val director = new Director(textbuilder)
      director.construct()
      val result = textbuilder.getResult()
      println(result)
    } else if (args(0) == "html") {
      val htmlbuilder = new HTMLBuilder()
      val director = new Director(htmlbuilder)
      director.construct()
      val filename = htmlbuilder.getResult()
      println(filename + "が作成されました。")
    } else if (args(0) == "frame") {
      val framebuilder = new FrameBuilder()
      val director = new Director(framebuilder)
      director.construct()
      val frame = framebuilder.getResult()
      frame.setVisible(true)
    } else {
      usage()
      System.exit(0)
    }

    def usage(): Unit = {
      println("Usage: java Main plain プレーンテキストで文書作成")
      println("Usage: java Main html  HTMLテキストで文書作成")
    }
  }
}