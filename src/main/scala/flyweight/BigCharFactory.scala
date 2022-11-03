package flyweight

import java.util

class BigCharFactory private() {
  private val pool = new util.HashMap[String, BigChar]()

  def getBigChar(charname: Char): BigChar = synchronized {
    var bc = pool.get("" + charname)
    if (bc == null) {
      bc = new BigChar(charname)
      pool.put("" + charname, bc)
    }
    bc
  }
}

object BigCharFactory {
  private val singleton = new BigCharFactory()

  def getInstance(): BigCharFactory = singleton
}