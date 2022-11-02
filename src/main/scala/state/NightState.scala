package state

class NightState extends State {
  override def doClock(context: Context, hour: Int): Unit = {
    if (12 <= hour && hour < 13) {
      context.changeState(NoonState.getInstance())
    } else if (9 <= hour && hour < 17) {
      context.changeState(DayState.getInstance())
    }
  }

  override def doUse(context: Context): Unit = {
    context.callSecurityCenter("非常：夜間の金庫使用！")
  }

  override def doAlarm(context: Context): Unit = {
    context.callSecurityCenter("非常ベル(夜間)")
    context.changeState(UrgentState.getInstance())
  }

  override def doPhone(context: Context): Unit = {
    context.recordLog("夜間の通話録音")
  }

  override def toString: String = "[夜間]"
}

object NightState {
  private val singleton = new NightState()

  def getInstance(): NightState = singleton
}
