import minesweeper.MinesweeperGame
import minesweeper.board.BoardElement
import minesweeper.board.PlayingGameBoard
import minesweeper.board.render.DefaultBoardRender
import minesweeper.board.render.MinesweeperBoardRender
import minesweeper.position.RandomPosition
import minesweeper.view.DefaultView
import minesweeper.view.Input
import minesweeper.view.Output

fun main() {
    val inputValidates = listOf(::isOnlyNumber, ::isPositiveNumber)

    Output.printHeightMessage()
    val height = convertStringToInt(Output::printInputValidate, inputValidates)

    Output.printWidthMessage()
    val width = convertStringToInt(Output::printInputValidate, inputValidates)

    Output.printMinesMessage()
    val mineCount = convertStringToInt(Output::printInputValidate, inputValidates)

    val boardElement = BoardElement(height, width)
    val mines = RandomPosition(boardElement).generate(mineCount)

    val playingGameBoard = PlayingGameBoard(DefaultBoardRender(mines)(boardElement), MinesweeperBoardRender(mines)(boardElement))
    val minesweeperGame = MinesweeperGame(playingGameBoard, boardElement, DefaultView())

    Output.printStartMessage()
    minesweeperGame.gameStart()
}

private tailrec fun convertStringToInt(
    exceptionCallback: () -> Unit,
    predicates: List<(String) -> Boolean>
): Int {
    val line = Input.getLine()
    return if (predicates.all { it.invoke(line) }) line.toInt()
        else {
            exceptionCallback()
            convertStringToInt(exceptionCallback, predicates)
        }
}

private fun isOnlyNumber(line: String): Boolean = line.all { it.isDigit() }

private fun isPositiveNumber(line: String): Boolean = line.toInt() > 0
