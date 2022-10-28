package singleton

class TicketMaker private() {
  private var ticket = 1000

  def getNextTicketNumber(): Int = {
    synchronized {
      val result = ticket
      ticket += 1
      result
    }
  }
}

object TicketMaker {
  private val singleton = new TicketMaker()

  def getInstance(): TicketMaker = singleton
}
