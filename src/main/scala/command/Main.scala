package command

import command._
import drawer._

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener, MouseEvent, MouseMotionAdapter, WindowAdapter, WindowEvent}
import javax.swing.{Box, BoxLayout, JButton, JFrame}

class Main(title: String) extends JFrame(title) with ActionListener {
  private val history = new MacroCommand()
  private val canvas = new DrawCanvas(400, 400, history)
  private val clearButton = new JButton("clear")
  private val redButton = new JButton("red")
  private val greenButton = new JButton("green")
  private val blueButton = new JButton("blue")
  private val undoButton = new JButton("undo")

  this.addWindowListener(new WindowAdapter() {
    override def windowClosing(e: WindowEvent): Unit = {
      System.exit(0)
    }
  })
  canvas.addMouseMotionListener(new MouseMotionAdapter() {
    override def mouseDragged(e: MouseEvent): Unit = {
      val cmd = new DrawCommand(canvas, e.getPoint())
      history.append(cmd)
      cmd.execute()
    }
  })
  clearButton.addActionListener(this)
  redButton.addActionListener(this)
  greenButton.addActionListener(this)
  blueButton.addActionListener(this)
  undoButton.addActionListener(this)

  val buttonBox = new Box(BoxLayout.X_AXIS)
  buttonBox.add(clearButton)
  buttonBox.add(redButton)
  buttonBox.add(greenButton)
  buttonBox.add(blueButton)
  buttonBox.add(undoButton)
  val mainBox = new Box(BoxLayout.Y_AXIS)
  mainBox.add(buttonBox)
  mainBox.add(canvas)
  getContentPane().add(mainBox)

  pack()
  show()

  override def actionPerformed(e: ActionEvent): Unit = {
    if (e.getSource() == clearButton) {
      history.clear()
      canvas.init()
      canvas.repaint()
    } else if (e.getSource() == redButton) {
      val cmd = new ColorCommand(canvas, Color.red)
      history.append(cmd)
      cmd.execute()
    } else if (e.getSource() == greenButton) {
      val cmd = new ColorCommand(canvas, Color.green)
      history.append(cmd)
      cmd.execute()
    } else if (e.getSource() == blueButton) {
      val cmd = new ColorCommand(canvas, Color.blue)
      history.append(cmd)
      cmd.execute()
    } else if (e.getSource() == undoButton) {
      history.undo()
      canvas.repaint()
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    new Main("Command Pattern Sample")
  }
}
