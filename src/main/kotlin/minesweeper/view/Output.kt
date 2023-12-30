package minesweeper.view

object Output {

    private const val INPUT_HEIGHT = "높이를 입력하세요."
    private const val INPUT_WIDTH = "너비를 입력하세요."
    private const val INPUT_MINES = "지뢰는 몇 개인가요?"
    private const val INPUT_POSITIVE_NUMBER = "양수만 입력하여 주세요."
    private const val OUTPUT_START_MINESWEEPER = "지뢰찾기 게임 시작"
    private const val OPEN = "open: "
    private const val LOSE_GAME = "Lose Game."
    private const val WIN_GAME = "Win Game."

    fun printHeightMessage() {
        println(INPUT_HEIGHT)
    }

    fun printWidthMessage() {
        println(INPUT_WIDTH)
    }

    fun printMinesMessage() {
        println(INPUT_MINES)
    }

    fun printInputValidate() {
        println(INPUT_POSITIVE_NUMBER)
    }

    fun printStartMessage() {
        println(OUTPUT_START_MINESWEEPER)
    }

    fun printCellMessage() {
        print(OPEN)
    }

    fun printAny(any: Any) {
        println(any)
    }

    fun printLoseGame() {
        println(LOSE_GAME)
    }

    fun printWinGame() {
        println(WIN_GAME)
    }
}
