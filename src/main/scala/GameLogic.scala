import scala.io.StdIn.readLine

object GameLogic extends App {

  val character1 = Character("Ash", "green", "green", "brown", isMale = true, hasGlasses = false, hasBeard = true, hasHat = false, hasPet = false)
  val character2 = Character("Nemo", "pink", "brown", "black", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = false)
  val character3 = Character("Tudor", "green", "green", "brown", isMale = true, hasGlasses = true, hasBeard = true, hasHat = false, hasPet = false)
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
    println("3. Give me a hint!")
    val userChoice: String = readLine("Your choice: ")
    if (userChoice == "1") {
      val nameGuess: String = readLine("Enter character's name: ")
      if (board.guessCharacter(nameGuess)) {
        println("You've won, congrats!")
        System.exit(0)
      } else {
        println("Try again, that wasn't the character's name.")
      }
    } else if (userChoice == "2") {
      println("1. Is the character male?")
      println("2. Is the character female?")
      println("3. Does the character have glasses?")
      println("4. Does the character have a pet?")
      println("5. Does the character have a beard?")
      println("6. Does the character have a hat?")
      println("7. Does the character have a (Colour) hair?")
      println("8. Does the character have a (Colour) eyes?")

      println("9. Does the character have a (Colour) jumper?")
      val userQuestionChoice: String = readLine("Choose a question!")
      if (userQuestionChoice == "1") {
        val response = board.askQuestion("male")
        if (response) {
          println("Well done, the character is MALE!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "2") {
        val response = board.askQuestion("female")
        if (response) {
          println("Well done, the character is FEMALE!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "3") {
        val response = board.askQuestion("glasses")
        if (response) {
          println("Well done, the character has glasses!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "4") {
        val response = board.askQuestion("pet")
        if (response) {
          println("Well done, the character has a pet!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "5") {
        val response = board.askQuestion("beard")
        if (response) {
          println("Well done, the character has a beard!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "6") {
        val response = board.askQuestion("hat")
        if (response) {
          println("Well done, the character has a hat!")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "7") {
        val hairColour: String = readLine("Enter the hair colour!🔫: ")
        val response = board.askQuestion("hair", hairColour)
        if (response) {
          println(s"Well done, the character has $hairColour hair !")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "8") {
        val eyeColour: String = readLine("Enter the eye colour!🔫: ")
        val response = board.askQuestion("eyes", eyeColour)
        if (response) {
          println(s"Well done, the character has $eyeColour eyes !")
        } else {
          println("Loserrr! try again!")
        }
      }
      if (userQuestionChoice == "9") {
        val jumperColour: String = readLine("Enter the jumper colour!🔫: ")
        val response = board.askQuestion("jumper", jumperColour)
        if (response) {
          println(s"Well done, the character has $jumperColour jumper !")
        } else {
          println("Loserrr! try again!")
        }
      }
    }
    if (userChoice == "3") {
      println("1. Tell me a fact about the character")
      println("2. Remove one wrong character from the game")
      val userHintChoice: String = readLine("Enter hint choice (1 or 2)")
      if (userHintChoice == "2") {
        println(s"A wrong character is ${board.wrongCharacter.name}")
      }
    }
  }
}
