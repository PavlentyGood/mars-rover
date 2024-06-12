package ru.pavlentygood.marsrover.domain

const val MIN_LIMIT = 0

data class Coordinate(
    val value: Int,
    val limit: Int
) {
    fun add(offset: Int) =
        (value + offset).let {
            if (isValid(it, limit)) Coordinate(it, limit)
            else this
        }

    companion object {
        fun create(value: Int, limit: Int) =
            if (isValid(value, limit)) Coordinate(value, limit)
            else throw IllegalArgumentException()

        private fun isValid(value: Int, limit: Int) =
            value in MIN_LIMIT..limit
    }
}
