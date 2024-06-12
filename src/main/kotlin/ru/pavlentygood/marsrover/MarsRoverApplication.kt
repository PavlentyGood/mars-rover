package ru.pavlentygood.marsrover

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.pavlentygood.marsrover.console.Console
import ru.pavlentygood.marsrover.usecase.ExploreMarsScenario

@SpringBootApplication
class MarsRoverApplication

fun main(args: Array<String>) {
    runApplication<MarsRoverApplication>(*args)

     while (true) {
         Console(System.`in`, System.out, ExploreMarsScenario())
             .process()
     }
}
