package ru.pavlentygood.marsrover

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    fun onRight() = turn(1)
    fun onLeft() = turn(values().size - 1)

    private fun turn(times: Int): Direction {
        val index = (ordinal + times) % values().size
        return values()[index]
    }
}
