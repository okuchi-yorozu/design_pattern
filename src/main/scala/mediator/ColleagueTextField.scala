package mediator

import java.awt.{Color, TextField}
import java.awt.event.{TextEvent, TextListener}

class ColleagueTextField(text: String, columns: Int) extends TextField(text, columns) with TextListener with Colleague {
  private var mediator: Mediator = null

  override def setMediator(mediator: Mediator): Unit = this.mediator = mediator

  override def setColleagueEnabled(enabled: Boolean): Unit = {
    setEnabled(enabled)
    setBackground(if (enabled) {
      Color.white
    } else {
      Color.lightGray
    })
  }

  override def textValueChanged(e: TextEvent): Unit = mediator.colleagueChanged()
}
