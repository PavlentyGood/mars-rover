package ru.pavlentygood.marsrover

data class Rov(
    val x: Int,
    val y: Int,
    val currentVector: Vector,
    val vectors: List<Vector>
) {
    val side: Side = currentVector.side

    fun step() =
        currentVector.step(x, y).let {
            Rov(
                x = it[0],
                y = it[1],
                currentVector = currentVector,
                vectors = vectors
            )
        }

    fun right() = Rov(
        x = x,
        y = y,
        currentVector = vectors[nextVectorIndex()],
        vectors = vectors
    )

    private fun nextVectorIndex() = (vectors.indexOf(currentVector) + 1) % 4
}
