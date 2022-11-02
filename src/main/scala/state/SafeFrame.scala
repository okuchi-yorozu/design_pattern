package state

import java.awt.{BorderLayout, Button, Color, Frame, Panel, TextArea, TextField}
import java.awt.event.{ActionEvent, ActionListener}

class SafeFrame(title: String) extends Frame(title) with ActionListener with Context {
  private val textClock = new TextField(60)
  private val textScreen = new TextArea(10, 60)
  private val buttonUse = new Button("金庫使用")
  private val buttonAlarm = new Button("非常ベル")
  private val buttonPhone = new Button("通常通話")
  private val buttonExit = new Button("終了")

  private var state2: State = DayState.getInstance()

  setBackground(Color.lightGray)
  setLayout(new BorderLayout())
  add(textClock, BorderLayout.NORTH)
  textClock.setEditable(false)
  add(textScreen, BorderLayout.CENTER)
  textScreen.setEditable(false)
  val panel = new Panel()
  panel.add(buttonUse)
  panel.add(buttonAlarm)
  panel.add(buttonPhone)
  panel.add(buttonExit)
  add(panel, BorderLayout.SOUTH)

  pack()
  show()

  buttonUse.addActionListener(this)
  buttonAlarm.addActionListener(this)
  buttonPhone.addActionListener(this)
  buttonExit.addActionListener(this)

  override def actionPerformed(e: ActionEvent): Unit = {
    println(e.toString())
    if (e.getSource() == buttonUse) {
      state2.doUse(this)
    } else if (e.getSource() == buttonAlarm) {
      state2.doAlarm(this)
    } else if (e.getSource() == buttonPhone) {
      state2.doPhone(this)
    } else if (e.getSource() == buttonExit) {
      System.exit(0)
    } else {
      println("?")
    }
  }

  def setClock(hour: Int): Unit = {
    var clockstring = "現在時刻は"
    if (hour < 10) {
      clockstring += "0" + hour + ":00"
    } else {
      clockstring += hour + ":00"
    }

    println(clockstring)
    textClock.setText(clockstring)
    state2.doClock(this, hour)
  }

  def changeState(state: State): Unit = {
    println(this.state2 + "から" + state + "へ状態が変化しました。")
    this.state2 = state
  }

  def callSecurityCenter(msg: String): Unit = {
    textScreen.append("call! " + msg + "\n")
  }

  def recordLog(msg: String): Unit = {
    textScreen.append("record ... " + msg + "\n")
  }
}

