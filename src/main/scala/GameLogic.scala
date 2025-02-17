import scala.io.StdIn.readLine

object GameLogic extends App {

  val character1 = Character("Ash", "green", "green", "brown", isMale = true, hasGlasses = false, hasBeard = true, hasHat = false, hasPet = false)
  val character2 = Character("Nemo", "pink", "brown", "black", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = false)
  val character3 = Character("Tudor", "green", "green", "brown", isMale = true, hasGlasses = false, hasBeard = true, hasHat = false, hasPet = false)
  val character4 = Character("Lan", "green", "green", "brown", isMale = false, hasGlasses = false, hasBeard = false, hasHat = false, hasPet = false)
  val character5 = Character("April", "green", "green", "brown", isMale = false, hasGlasses = false, hasBeard = false, hasHat = false, hasPet = true)

  val board = Board(List(character1, character2, character3, character4, character5))

  println("Welcome to Quess Who!")
  println("Here are the characters on the board: ")
  board.characters.foreach(character => println(character.name))

  println("Time to guess!")

  while (true) {
    println("Select one of the options below:")
    println("1. Guess character")
    println("2. Ask question")
    val userChoice: String = readLine("Your choice: ")
    if (userChoice == "1") {
      val nameGuess: String = readLine("Enter character's name: ")
      if (board.guessCharacter(nameGuess)) {
        println("You've won, congrats!")
        System.exit(0)
      } else {
        println("Try again, that wasn't the character's name.")
      }
    }
  }
}
