package ru.pavlentygood.marsrover.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import ru.pavlentygood.marsrover.domain.Side.*

class SideTest {

    @Test
    fun next() {
        NORTH.next() shouldBe EAST
        EAST.next() shouldBe SOUTH
        SOUTH.next() shouldBe WEST
        WEST.next() shouldBe NORTH
    }
}
