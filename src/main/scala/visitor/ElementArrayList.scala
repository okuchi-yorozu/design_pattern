package visitor

import java.util

class ElementArrayList extends util.ArrayList[Element] with Element {
  def accept(v: Visitor): Unit = {
    val it = iterator()
    while(it.hasNext()) {
      val a = it.next()
      a.accept(v)
    }
  }

}
