package nl.rptx.yakusokugeiko.services

import nl.rptx.yakusokugeiko.Assignment
import kotlin.random.Random

class AssignmentService {
    fun permute(defenses: List<String>, attacks: List<String>): Sequence<Assignment> {
        return sequence {
            for(attack in attacks)
                for (defense in defenses)
                    yield(Assignment(defense, attack))
        }
    }

    fun randomize(assignments: Iterable<Assignment>): Iterable<Assignment> {
        return assignments
            .shuffled()
    }
}