package observer

import java.awt.{BorderLayout, Button, Canvas, Color, Frame, Graphics, TextField}
import java.awt.event.{ActionEvent, ActionListener}

class FrameObserver extends Frame("FrameObserver") with Observer with ActionListener {
  private val textGraph = new GraphText(60)
  private val canvasGraph = new GraphCanvas()
  private val buttonClose = new Button("Close")

  setLayout(new BorderLayout())
  setBackground(Color.lightGray)
  textGraph.setEditable(false)
  canvasGraph.setSize(500, 500)
  add(textGraph, BorderLayout.NORTH)
  add(canvasGraph, BorderLayout.CENTER)
  add(buttonClose, BorderLayout.SOUTH)
  buttonClose.addActionListener(this)
  pack()
  show()

  override def actionPerformed(e: ActionEvent): Unit = {
    println(e.toString())
    System.exit(0)
  }

  override def update(generator: NumberGenerator): Unit = {
    textGraph.update(generator)
    canvasGraph.update(generator)
  }
}

class GraphText(columns: Int) extends TextField(columns) with Observer {
  override def update(generator: NumberGenerator): Unit = {
    val number = generator.getNumber()
    var text = number + ":"
    for (_ <- 0 until number) {
      text += '*'
    }
    setText(text)
  }
}

class GraphCanvas extends Canvas with Observer {
  private var number = 0

  override def update(generator: NumberGenerator): Unit = {
    number = generator.getNumber()
    repaint()
  }

  override def paint(g: Graphics): Unit = {
    val width = getWidth()
    val height = getHeight()
    g.setColor(Color.white)
    g.fillArc(0, 0, width, height, 0, 360)
    g.setColor(Color.red)
    g.fillArc(0, 0, width, height, 90, - number * 360 / 50)
  }
}