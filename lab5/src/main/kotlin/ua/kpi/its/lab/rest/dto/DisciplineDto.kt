package ua.kpi.its.lab.rest.dto

data class DisciplineRequest(
    val name: String,
    val institution: String,
    val specialtyCode: String,
    val semester: Int,
    val numberOfHours: Int,
    val approvalDate: String,
    val exam: Boolean
)

data class DisciplineResponse(
    val id: Long,
    val name: String,
    val institution: String,
    val specialtyCode: String,
    val semester: Int,
    val numberOfHours: Int,
    val approvalDate: String,
    val exam: Boolean
)
