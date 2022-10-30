package bridge

import java.io.{BufferedReader, FileReader, IOException}

class FileDisplayImpl(private val filename: String) extends DisplayImpl {
  private var reader: BufferedReader = null
  private final val MAX_READHEAD_LIMIT = 4096

  override def rawOpen(): Unit = {
    try {
      reader = new BufferedReader(new FileReader(filename))
      reader.mark(MAX_READHEAD_LIMIT)
    } catch {
      case e: IOException => e.printStackTrace()
    }
    println("=-=-=-=-=-=" + filename + "=-=-=-=-=-=")
  }

  override def rawPrint(): Unit = {
    try {
      var line: String = null
      reader.reset()
      while ({line = reader.readLine(); line != null}) {
        println("> " + line)
      }
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  override def rawClose(): Unit = {
    println("=-=-=-=-=-=")
    try {
      reader.close()
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }
}
