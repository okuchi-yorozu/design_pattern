package mediator

import java.awt.Button

class ColleagueButton(caption: String) extends Button(caption) with Colleague {
  private var mediator: Mediator = null

  override def setMediator(mediator: Mediator): Unit = this.mediator = mediator

  override def setColleagueEnabled(enabled: Boolean): Unit = setEnabled(enabled)
}
