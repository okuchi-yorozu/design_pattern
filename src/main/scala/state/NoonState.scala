package state

class NoonState extends State {
  override def doClock(context: Context, hour: Int): Unit = {
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance())
    } else if (9 <= hour && hour < 12 || 13 <= hour && hour < 17) {
      context.changeState(DayState.getInstance())
    }
  }

  override def doUse(context: Context): Unit = {
    context.callSecurityCenter("非常：昼食時の金庫使用！")
  }

  override def doAlarm(context: Context): Unit = {
    context.callSecurityCenter("非常ベル(昼食時)")
  }

  override def doPhone(context: Context): Unit = {
    context.recordLog("昼食時の通話録音")
  }

  override def toString: String = "[昼食時]"
}

object NoonState {
  private val singleton = new NoonState()

  def getInstance(): NoonState = singleton
}
