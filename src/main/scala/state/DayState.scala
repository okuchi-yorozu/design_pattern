package state

class DayState extends State {
  override def doClock(context: Context, hour: Int): Unit = {
    if (hour < 9 || 17 <= hour) {
      context.changeState(NightState.getInstance())
    } else if (12 <= hour && hour < 13) {
      context.changeState(NoonState.getInstance())
    }
  }

  override def doUse(context: Context): Unit = {
    context.recordLog("金庫使用(昼間)")
  }

  override def doAlarm(context: Context): Unit = {
    context.callSecurityCenter("非常ベル(昼間)")
    context.changeState(UrgentState.getInstance())
  }

  override def doPhone(context: Context): Unit = {
    context.callSecurityCenter("通常の通話(昼間)")
  }

  override def toString: String = "[昼間]"
}

object DayState {
  private val singleton = new DayState()
  def getInstance(): DayState = singleton
}
