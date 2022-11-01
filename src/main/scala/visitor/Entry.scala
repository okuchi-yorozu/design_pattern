package visitor

import java.util

trait Entry extends Element {
  def getName(): String
  def getSize(): Int
  def add(entry: Entry): Entry = throw new FileTreatmentException()
  def iterator(): util.Iterator[Entry] = throw new FileTreatmentException()
  override def toString(): String = getName() + " (" + getSize() + ")"
}
