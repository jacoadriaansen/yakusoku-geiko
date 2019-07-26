package nl.rptx.yakusokugeiko

import nl.rptx.yakusokugeiko.services.AssignmentService
import org.junit.Test

import org.junit.Assert.*

class RandomSelection {
    @Test
    fun addition_isCorrect() {
        var pair1 = Assignment("Mukae Doshi", "Maegeri")
        var pairs = listOf(pair1)

        var state = YakuSokuGeikoState(pairs)
        var pair = state.getNext()

        assertEquals ("Mukae Doshi", pair.defense)
        assertEquals ("Maegeri", pair.attack)
    }

    @Test
    fun addition_isCorrect_two() {
        var pair1 = Assignment("Mukae Doshi", "Maegeri")
        var pair2 = Assignment("Yukea Chigae", "Kote Geashi")
        var pairs = listOf(pair1, pair2)

        var state = YakuSokuGeikoState(pairs)
        state.getNext()
        var pair = state.getNext()

        assertEquals ("Yukea Chigae", pair.defense)
        assertEquals ("Kote Geashi", pair.attack)
    }

    @Test
    fun addition_isCorrect_back_to_one() {
        var pair1 = Assignment("Mukae Doshi", "Maegeri")
        var pair2 = Assignment("Yukea Chigae", "Kote Geashi")
        var pairs = listOf(pair1, pair2)

        var state = YakuSokuGeikoState(pairs)
        state.getNext()
        state.getNext()

        var pair = state.getNext()

        assertEquals ("Mukae Doshi", pair.defense)
        assertEquals ("Maegeri", pair.attack)
    }

    @Test
    fun permute_techniques() {
        val defenses = listOf("Mukae Doshi", "Yakae Chi Gae")
        var attacks = listOf("Jun-tsuki", "Maegeri")

        val permutations = AssignmentService().permute(defenses, attacks)
        assertEquals(4, permutations.count())
    }
}

