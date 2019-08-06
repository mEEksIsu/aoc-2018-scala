package days

object DayRunner extends App {
  val days = Map(
    1 -> new Day1,
    2 -> new Day2,
  )

  run(2)

  def run(day: Int): Unit = {
    days.get(day) match {
      case None => println(s"No solution found for Day $day.")
      case Some(dayToRun) =>
        val (solution1, solution2) = dayToRun.solve(s"src/main/resources/Day$day.txt")
        println(s"Part 1 solution: $solution1")
        println(s"Part 2 solution: $solution2")
    }
  }
}
