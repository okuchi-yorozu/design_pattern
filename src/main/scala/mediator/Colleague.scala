package mediator

trait Colleague {
  def setMediator(mediator: Mediator): Unit
  def setColleagueEnabled(enabled: Boolean): Unit
}
