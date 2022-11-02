package mediator

trait Mediator {
  def createColleagues(): Unit
  def colleagueChanged(): Unit
}
