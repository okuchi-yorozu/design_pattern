package memento

import memento.game.{Gamer, Memento}

import java.io.{FileInputStream, FileNotFoundException, FileOutputStream, IOException, ObjectInputStream, ObjectOutputStream}
import java.util.zip.{DeflaterOutputStream, InflaterInputStream}

object Main {
  final val SAVEFILENAME: String = "game.dat"

  def main(args: Array[String]): Unit = {
    val gamer = new Gamer(100)
    var memento = loadMemento()
    if (memento != null) {
      println("前回保存した結果からスタートします。")
      gamer.restoreMemento(memento)
    } else {
      println("新規にスタートします。")
      memento = gamer.createMemento()
    }

    for (i <- 0 until 100) {
      println("====" + i)
      println("現状:" + gamer)

      gamer.bet()

      println("所持金は" + gamer.getMoney() + "円になりました。")

      if (gamer.getMoney() > memento.getMoney()) {
        println("    (だいぶ増えたので、現在の状態を保存しておこう)")
        memento = gamer.createMemento()
        saveMemento(memento)
      } else if (gamer.getMoney() < memento.getMoney() / 2) {
        println("    (だいぶ減ったので、以前の状態を復帰しよう)")
        gamer.restoreMemento(memento)
      }

      try {
        Thread.sleep(1000)
      } catch {
        case e: InterruptedException =>
      }

      println("")
    }
  }

  def saveMemento(memento: Memento): Unit = {
    try {
      val out = new ObjectOutputStream(new DeflaterOutputStream(new FileOutputStream(SAVEFILENAME)))
      out.writeObject(memento)
      out.close()
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  def loadMemento(): Memento = {
    var memento: Memento = null
    try {
      val in = new ObjectInputStream(new InflaterInputStream(new FileInputStream(SAVEFILENAME)))
      memento = in.readObject().asInstanceOf[Memento]
      in.close()
    } catch {
      case e: FileNotFoundException => println(e.toString())
      case e: IOException => e.printStackTrace()
      case e: ClassNotFoundException => e.printStackTrace()
    }

    memento
  }
}

