package ru.pavlentygood.marsrover

const val FORWARD = 1
const val BACKWARD = -FORWARD

data class Way(
    val offset: Int,
    val limit: Int
) {
    fun step(value: Int) =
        if (value == limit) value
        else value + offset
}
