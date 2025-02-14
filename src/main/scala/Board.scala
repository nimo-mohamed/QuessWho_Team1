case class Board (characters: List[Character]) {

  val characterToGuess: Character = characters.head
  def guessCharecter(name: String) : Boolean = {
  characterToGuess.name == name
  }

}
