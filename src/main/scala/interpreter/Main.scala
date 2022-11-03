package interpreter

import interpreter.language.{Context, InterpreterFacade, ProgramNode}
import interpreter.turtle.TurtleCanvas

import java.awt.{BorderLayout, Frame, TextField}
import java.awt.event.{ActionEvent, ActionListener, WindowAdapter, WindowEvent}
import java.io.{BufferedReader, FileReader}

class Main(title: String) extends Frame(title) with ActionListener {
  private val canvas = new TurtleCanvas(400, 400)
  private val facade = new InterpreterFacade(canvas)
  private val programTextField = new TextField("program repeat 3 go right go left end end")

  canvas.setExecutor(facade)
  setLayout(new BorderLayout())
  programTextField.addActionListener(this)

  this.addWindowListener(new WindowAdapter() {
    override def windowClosing(e: WindowEvent): Unit = {
      System.exit(0)
    }
  })

  add(programTextField, BorderLayout.NORTH)
  add(canvas, BorderLayout.CENTER)
  pack()
  parseAndExecute()
  show()

  override def actionPerformed(e: ActionEvent): Unit = {
    if (e.getSource() == programTextField) {
      parseAndExecute()
    }
  }

  private def parseAndExecute() = {
    val programText = programTextField.getText()
    println("programText = " + programText)
    facade.parse(programText)
    canvas.repaint()
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    //    try {
    //      val reader = new BufferedReader(new FileReader("program.txt"))
    //      var text: String = null
    //      while ( {
    //        text = reader.readLine()
    //        text != null
    //      }) {
    //        println("text = \"" + text + "\"")
    //        val node = new ProgramNode()
    //        node.parse(new Context(text))
    //        println("node = " + node)
    //      }
    //      reader.close()
    //    } catch {
    //      case e: Exception => e.printStackTrace()
    //    }
    new Main("Interpreter Pattern Sample")
  }
}