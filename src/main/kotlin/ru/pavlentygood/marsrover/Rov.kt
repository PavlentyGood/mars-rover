package ru.pavlentygood.marsrover

data class Rov(
    val x: Coord,
    val y: Coord,
    val side: Side
) {
    fun step() =
        Rov(
            x = x.add(side.xOffset),
            y = y.add(side.yOffset),
            side = side
        )

    fun right() =
        Rov(
            x = x,
            y = y,
            side = side.next()
        )
}
