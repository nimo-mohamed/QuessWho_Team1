object GameLogic extends App {

  val character1 = Character("Ash", isMale = true, "Green", "brown")
  val character2 = Character("Nemo", isMale = false, "brown", "black")
  val character3 = Character("Tudor", isMale = true, "brown", "black")
  val character4 = Character("Lan", isMale = false, "Green", "black")
  val character5 = Character("April", isMale = false, "red", "pink")


  val board = Board(List(character1, character2))

  println(board.guessCharecter("Lan"))
  println(board.askQuestion("male"))
  println(board.askQuestion("female"))
  println(board.askQuestion("hair", "brown"))
}
