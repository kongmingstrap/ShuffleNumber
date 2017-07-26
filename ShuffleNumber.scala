import scala.util.{Try, Success, Failure, Random}

object ShuffleNumber {
  def main(args: Array[String]): Unit = {

    val numbers: Array[Int] = args.length match {
      case 0 | 1 => {
        println("required 2 args\n")
        return
      }
      case _ => {
        Try((args(0).toInt, args(1).toInt)) match {
          case Success(values) => {
            values match {
              case (s: Int, e: Int) => Array.range(s, e)
              case _ => Array()
            }
          }
          case Failure(error) => {
            println(error.toString)
            return
          }
        }
      }
    }

    val shuffle = Random.shuffle(numbers.toList)
    var count = 0

    do {
      print("INPUT => ")
      val inputs = scala.io.StdIn.readLine().split(' ')
      println("------------")
      count = Try(inputs.head.toInt) match {
        case Success(value) => {
          val slice = shuffle.slice(count, count + value)
          println(slice.mkString("\n"))
          count + value
        }
        case Failure(error) => {
          println(error.toString)
          return
        }
      }

      println("------------")
    } while (count < shuffle.length)
  }
}