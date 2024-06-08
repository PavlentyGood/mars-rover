package ru.pavlentygood.marsrover

data class Rov(
    val point: Point,
    val currentVector: Vector,
    val vectors: List<Vector>
) {
    val x = point.x
    val side = currentVector.side

    fun step() = Rov(
        point = currentVector.step(point),
        currentVector = currentVector,
        vectors = vectors
    )

    fun right() = Rov(
        point = point,
        currentVector = vectors[nextVectorIndex()],
        vectors = vectors
    )

    private fun nextVectorIndex() = (vectors.indexOf(currentVector) + 1) % 4
}
