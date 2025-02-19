import scala.io.StdIn.readLine

object GameLogic extends App {

  /**
   * Initializes the game board with predefined characters and players.
   *
   * @return The initialized game board.
   */
  private def initializeBoard: Board = {
    val character1 = Character("Alice", "blue", "blonde", "red", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = true)
    val character2 = Character("Bob", "brown", "black", "blue", isMale = true, hasGlasses = false, hasBeard = true, hasHat = true, hasPet = false)
    val character3 = Character("Charlie", "green", "brown", "green", isMale = true, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = true)
    val character4 = Character("Diana", "hazel", "red", "yellow", isMale = false, hasGlasses = false, hasBeard = false, hasHat = true, hasPet = false)
    val character5 = Character("Eve", "blue", "black", "purple", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = true)
    val character6 = Character("Frank", "brown", "blonde", "orange", isMale = true, hasGlasses = false, hasBeard = true, hasHat = true, hasPet = false)
    val character7 = Character("Grace", "green", "brown", "pink", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = true)
    val character8 = Character("Hank", "hazel", "red", "blue", isMale = true, hasGlasses = false, hasBeard = true, hasHat = true, hasPet = false)
    val character9 = Character("Ivy", "blue", "black", "green", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = true)
    val character10 = Character("Jack", "brown", "blonde", "yellow", isMale = true, hasGlasses = false, hasBeard = true, hasHat = true, hasPet = false)

    val player1: Player = Player("Andy")
    val player2: Player = Player("April")

    val board: Board = Board(List(character1, character2, character3, character4, character5, character6, character7, character8, character9, character10), player1, player2)

    board
  }

  /** The game board initialized with characters and players. */
  private val board: Board = initializeBoard

  /**
   * Prompts the user to guess the character's name and checks if the guess is correct.
   */
  private def guessNameOption(): Unit = {
    val nameGuess: String = readLine("Enter character's name: ").toLowerCase.capitalize

    if (board.guessCharacter(nameGuess)) {
      println(s"Congratulations, ${board.getCurrentPlayerName} you've won!")
      System.exit(0)
    } else {
      println("Try again, that wasn't the character's name.")
    }
  }

  /**
   * Prompts the user to ask a question about the character and checks if the answer is correct.
   */
  private def askQuestionOption(): Unit = {
    println("1. Is the character male?")
    println("2. Is the character female?")
    println("3. Does the character have glasses?")
    println("4. Does the character have a pet?")
    println("5. Does the character have a beard?")
    println("6. Does the character have a hat?")
    println("7. What is the character's hair color?")
    println("8. What is the character's eye color?")
    println("9. What is the character's jumper color?\n")

    val userQuestionNumber: String = readLine("Choose a question: ")

    val userQuestion: String = userQuestionNumber match {
      case "1" => "male"
      case "2" => "female"
      case "3" => "glasses"
      case "4" => "pet"
      case "5" => "beard"
      case "6" => "hat"
      case "7" => "hair"
      case "8" => "eyes"
      case "9" => "jumper"
      case _ => ""
    }

    val guess: String = if (userQuestionNumber.toInt >= 7) {
      readLine(s"Enter your guess for the $userQuestion: ").toLowerCase
    } else ""

    val response: Boolean = board.askQuestion(userQuestion, guess)

    if (response) {
      println(s"Your guess about the $userQuestion was correct!")
    } else {
      println(s"Your guess about the $userQuestion was incorrect!")
    }

    board.narrowCurrentPlayerRemainingCharacters(userQuestion, guess, negate = !response)
  }

  /**
   * Prompts the user to choose a hint option and provides the corresponding hint.
   */
  private def giveHintOption(): Unit = {
    println("1. Tell me a fact about the character")
    println("2. Remove one wrong character from the game\n")

    val userHintChoice: String = readLine("Enter hint choice: ")

    if (userHintChoice == "1") {
      println(board.getRandomTraitHint)
    } else if (userHintChoice == "2") {
      println(s"A wrong character is: ${board.getRandomWrongCharacterName}")
    } else {
      println("That's not a valid hint choice.")
    }
  }

  /**
   * Starts the game and manages the game loop.
   */
  private def startGame(): Unit = {
    println("Welcome to Quess Who!")
    println("Here are the characters on the board:\n")
    board.printCurrentPlayerRemainingCharacters()
    println("\nTime to guess!\n")

    while (true) {
      println(s"It's your turn ${board.getCurrentPlayerName}\n")
      println(s"These are your remaining characters, ${board.getCurrentPlayerName}:\n")
      board.printCurrentPlayerRemainingCharacters()
      println()
      println("Select one of the options below:\n")
      println("1. Guess character")
      println("2. Ask question")
      println("3. Give me a hint!\n")

      val userChoice: String = readLine("Your choice: ")
      println()

      if (userChoice == "1") {
        guessNameOption()
      } else if (userChoice == "2") {
        askQuestionOption()
      } else if (userChoice == "3") {
        giveHintOption()
      } else {
        println("That's not a valid choice.")
        board.switchPlayer()
      }

      board.switchPlayer()

      println()
    }
  }

  // Start the game
  startGame()
}
