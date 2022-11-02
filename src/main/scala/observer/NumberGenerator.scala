package observer

import java.util

trait NumberGenerator {
  private val observers = new util.ArrayList[Observer]()

  def addObserver(observer: Observer): Unit = {
    observers.add(observer)
  }

  def deleteObserver(observer: Observer): Unit = {
    observers.remove(observer)
  }

  def notifyObservers(): Unit = {
    val it = observers.iterator()
    while (it.hasNext()) {
      val o = it.next()
      o.update(this)
    }
  }

  def getNumber(): Int
  def execute(): Unit
}
