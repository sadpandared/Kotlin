package ua.kpi.its.lab.rest.dto

data class EducationalInstitutionRequest(
    val name: String,
    val accreditationLevel: Int,
    val address: String,
    val foundationDate: String,
    val numberOfFaculties: Int,
    val website: String,
    val militaryDepartment: Boolean
)

data class EducationalInstitutionResponse(
    val id: Long,
    val name: String,
    val accreditationLevel: Int,
    val address: String,
    val foundationDate: String,
    val numberOfFaculties: Int,
    val website: String,
    val militaryDepartment: Boolean
)
