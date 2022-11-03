package interpreter.turtle

import interpreter.language.{ExecuteException, Executor, ExecutorFactory}
import interpreter.turtle.TurtleCanvas.{DIRECTION_DOWN, DIRECTION_LEFT, DIRECTION_RIGHT, DIRECTION_UP, RADIUS, RELATIVE_DIRECTION_LEFT, RELATIVE_DIRECTION_RIGHT}

import java.awt.{Canvas, Color, Graphics, Point}

class TurtleCanvas(width: Int, height: Int) extends Canvas with ExecutorFactory {
  private var direction = 0
  private var position: Point = null
  private var executor: Executor = null

  setSize(width, height)
  initialize()

  def setExecutor(executor: Executor): Unit = {
    this.executor = executor
  }

  def setRelativeDirection(relativeDirection: Int): Unit = {
    setDirection(direction + relativeDirection)
  }

  def setDirection(direction: Int): Unit = {
    var d = direction
    if (d < 0) {
      d = 12 - (-d) % 12
    } else {
      d = direction % 12
    }
    this.direction = d
  }

  def go(length: Int): Unit = {
    var newx = position.x
    var newy = position.y

    direction match {
      case DIRECTION_UP => newy -= length
      case DIRECTION_RIGHT => newx += length
      case DIRECTION_DOWN => newy += length
      case DIRECTION_LEFT => newx -= length
      case _ =>
    }

    val g = getGraphics()
    if (g != null) {
      g.drawLine(position.x, position.y, newx, newy)
      g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1)
    }
    position.x = newx
    position.y = newy
  }

  override def createExecutor(name: String): Executor = {
    if (name.equals("go")) {
      new GoExecutor(this)
    } else if (name.equals("right")) {
      new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT)
    } else if (name.equals("left")) {
      new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT)
    } else {
      null
    }
  }

  def initialize(): Unit = {
    val size = getSize()
    position = new Point(size.width / 2, size.height / 2)
    direction = 0
    setForeground(Color.red)
    setBackground(Color.white)

    val g = getGraphics()
    if (g != null) {
      g.clearRect(0, 0, size.width, size.height)
    }
  }

  override def paint(g: Graphics): Unit = {
    initialize()
    if (executor != null) {
      try {
        executor.execute()
      } catch {
        case e: ExecuteException =>
      }
    }
  }
}

object TurtleCanvas {
  final val UNIT_LENGTH = 30
  final val DIRECTION_UP = 0
  final val DIRECTION_RIGHT = 3
  final val DIRECTION_DOWN = 6
  final val DIRECTION_LEFT = 9
  final val RELATIVE_DIRECTION_RIGHT = 3
  final val RELATIVE_DIRECTION_LEFT = -3
  final val RADIUS = 3
}

abstract class TurtleExecutor(protected val canvas: TurtleCanvas) extends Executor {
}

class GoExecutor(canvas: TurtleCanvas) extends TurtleExecutor(canvas) {
  override def execute(): Unit = canvas.go(TurtleCanvas.UNIT_LENGTH)
}

class DirectionExecutor(canvas: TurtleCanvas, private val relativeDirection: Int) extends TurtleExecutor(canvas) {
  override def execute(): Unit = canvas.setRelativeDirection(relativeDirection)
}
