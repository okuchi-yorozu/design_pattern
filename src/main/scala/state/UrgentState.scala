package state

class UrgentState extends State {
  override def doClock(context: Context, hour: Int): Unit = {
  }

  override def doUse(context: Context): Unit = {
    context.callSecurityCenter("非常：非常時の金庫使用！")
  }

  override def doAlarm(context: Context): Unit = {
    context.callSecurityCenter("非常ベル(非常時)")
  }

  override def doPhone(context: Context): Unit = {
    context.callSecurityCenter("通常の通話(非常時)")
  }

  override def toString: String = "[非常時]"
}

object UrgentState {
  private val singleton = new UrgentState()

  def getInstance(): UrgentState = singleton
}
