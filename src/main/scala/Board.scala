import scala.util.Random

case class Board(characters: List[Character]) {

  private val randomNumGen = new Random()
  private val randomIndex = randomNumGen.nextInt(characters.length)

  private val characterToGuess = characters(randomIndex)

  def guessCharacter(name: String): Boolean = {
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
    } else if (userQuestion == "jumper"){
      characterToGuess.jumperColour == guess
    } else if (userQuestion == "glasses"){
      characterToGuess.hasGlasses
    } else if (userQuestion == "pet"){
      characterToGuess.hasPet
    } else if (userQuestion == "beard"){
      characterToGuess.hasBeard
    } else if (userQuestion == "hat"){
      characterToGuess.hasHat
    } else false
  }
}
