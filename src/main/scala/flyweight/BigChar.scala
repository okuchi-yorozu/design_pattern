package flyweight

import java.io.{BufferedReader, FileReader, IOException}

class BigChar(private val charname: Char) {
  private var fontdata: String = null

  try {
    val reader = new BufferedReader(
      new FileReader("big" + charname + ".txt")
    )
    var line: String = null
    val buf = new StringBuffer()
    while ( {
      line = reader.readLine()
      line != null
    }) {
      buf.append(line)
      buf.append("\n")
    }
    reader.close()
    this.fontdata = buf.toString()
  } catch {
    case e: IOException => this.fontdata = charname + "?"
  }

  def print(): Unit = {
    System.out.print(fontdata)
  }
}
