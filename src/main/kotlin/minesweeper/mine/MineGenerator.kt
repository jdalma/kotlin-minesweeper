package minesweeper.mine

import minesweeper.board.Number
import minesweeper.position.Position
import minesweeper.position.PositionGenerateStrategy

class MineGenerator(
    private val mineCount: Number,
    private val randomPosition: PositionGenerateStrategy
) {

    fun generate(): Mines {
        val positions = mutableSetOf<Position>().apply {
            while (mineCount > this.size) {
                this.add(randomPosition.generate())
            }
        }
        return Mines(positions)
    }
}
