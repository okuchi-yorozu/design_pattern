package builder

import java.awt.event.{ActionEvent, ActionListener, WindowAdapter, WindowEvent}
import javax.swing.{Box, BoxLayout, JButton, JFrame, JLabel}

class FrameBuilder extends Builder with ActionListener {
  private val frame = new JFrame()
  private val box = new Box(BoxLayout.Y_AXIS)

  override def buildTitle(title: String): Unit = {
    frame.setTitle(title)
  }

  override def buildString(str: String): Unit = {
    box.add(new JLabel(str))
  }

  override def buildItems(items: List[String]): Unit = {
    val innerbox = new Box(BoxLayout.Y_AXIS)
    for (i <- items.indices) {
      val button = new JButton(items(i))
      button.addActionListener(this)
      innerbox.add(button)
    }
    box.add(innerbox)
  }

  override def buildDone(): Unit = {
    frame.getContentPane().add(box)
    frame.pack()
    frame.addWindowListener(new WindowAdapter {
      override def windowClosing(e: WindowEvent): Unit = System.exit(0)
    })
  }

  def getResult(): JFrame = frame

  override def actionPerformed(e: ActionEvent): Unit = println(e.getActionCommand())

}
