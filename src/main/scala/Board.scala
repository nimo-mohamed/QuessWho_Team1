case class Board (characters: List[Character]) {

  val characterToGuess: Character = characters.head
  def guessCharecter(name: String) : Boolean = {
  characterToGuess.name == name
  }

  def askQuestion(userQuestion: String, guess: String = ""): Boolean = {
    if (userQuestion == "male") {
      characterToGuess.isMale
    } else if (userQuestion == "female") {
      !characterToGuess.isMale
    } else if (userQuestion == "hair") {
      characterToGuess.hairColour == guess
    } else if (userQuestion == "eyes") {
      characterToGuess.eyeColour == guess
    } else false
  }
}
