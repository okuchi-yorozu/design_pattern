package mediator

import java.awt.event.{ItemEvent, ItemListener}
import java.awt.{Checkbox, CheckboxGroup}

class ColleagueCheckbox(caption: String, group: CheckboxGroup, state: Boolean) extends Checkbox(caption, group, state) with ItemListener with Colleague {
  private var mediator: Mediator = null

  override def setMediator(mediator: Mediator): Unit = this.mediator = mediator

  override def setColleagueEnabled(enabled: Boolean): Unit = {
    setEnabled(enabled)
  }

  override def itemStateChanged(e: ItemEvent): Unit = mediator.colleagueChanged()
}
