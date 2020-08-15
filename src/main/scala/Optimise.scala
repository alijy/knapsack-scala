import optimus.optimization._
import optimus.optimization.enums.SolverLib
import optimus.optimization.model.MPBinaryVar

object Optimise extends App {

  val capacity: Int = 10

  implicit val model: MPModel = MPModel(SolverLib.oJSolver)

  val book = MPBinaryVar("book")
  val clothes = MPBinaryVar("clothes")
  val tv = MPBinaryVar("tv")
  val bag = MPBinaryVar("bag")

  maximize(5 * book + 5 * clothes + 4 * tv + 3 * bag)
  subjectTo(6 * book + 5 * clothes + 7 * tv + 3 * bag <:= 10)

  start()

  println(s"objective: $objectiveValue")
  println(s"book = ${book.value} clothes = ${clothes.value} tv = ${tv.value} bag = ${bag.value}")

  release()
}
