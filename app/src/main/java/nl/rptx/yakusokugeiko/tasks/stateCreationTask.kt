package nl.rptx.yakusokugeiko.tasks

import nl.rptx.yakusokugeiko.Techniques
import nl.rptx.yakusokugeiko.YakuSokuGeikoState
import nl.rptx.yakusokugeiko.services.AssignmentService

fun createState(techniques: Techniques): YakuSokuGeikoState {
    val assignmentService = AssignmentService()

    val assignmentPairs =  assignmentService
        .permute(techniques.defenses, techniques.attacks)
        .asIterable()

    val assignmentList = assignmentService
        .randomize(assignmentService
            .randomize(assignmentService
                .randomize(assignmentPairs)))
                .toList()

    return YakuSokuGeikoState(assignmentList)
}