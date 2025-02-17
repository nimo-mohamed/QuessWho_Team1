object GameLogic extends App {

  val character1 = Character("Ash","green", "green", "brown", isMale = true, hasGlasses = false, hasBeard = true, hasHat = false, hasPet = false)
  val character2 = Character("Nemo","pink", "brown", "black", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = false)
  val character3 = Character("Tudor","green", "green", "brown", isMale = true, hasGlasses = false, hasBeard = true, hasHat = false, hasPet = false)
  val character4 = Character("Lan","green", "green", "brown", isMale = false, hasGlasses = false, hasBeard = false, hasHat = false, hasPet = false)
  val character5 = Character("April","green", "green", "brown", isMale = false, hasGlasses = false, hasBeard = false, hasHat = false, hasPet = true)



  val board = Board(List(character1, character2, character3,character4, character5))
println(board.characterToGuess)
  println(board.guessCharacter("Lan"))
  println(board.askQuestion("male"))
  println(board.askQuestion("female"))
  println(board.askQuestion("hair", "brown"))
}
