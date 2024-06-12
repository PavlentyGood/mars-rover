package ru.pavlentygood.marsrover

import ru.pavlentygood.marsrover.console.Console
import ru.pavlentygood.marsrover.usecase.ExploreMarsScenario

class MarsRoverApplication

fun main() {
     while (true) {
         Console(System.`in`, System.out, ExploreMarsScenario())
             .process()
     }
}
