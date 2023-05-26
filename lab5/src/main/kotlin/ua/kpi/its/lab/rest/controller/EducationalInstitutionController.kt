package ua.kpi.its.lab.rest.controller

import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.EducationalInstitutionRequest
import ua.kpi.its.lab.rest.dto.EducationalInstitutionResponse
import ua.kpi.its.lab.rest.entity.Discipline
import ua.kpi.its.lab.rest.entity.EducationalInstitution
import ua.kpi.its.lab.rest.svc.EducationalInstitutionService

@RestController
@RequestMapping("/institutions")
class EducationalInstitutionController(
    private val educationalInstitutionService: EducationalInstitutionService
) {
    @GetMapping
    fun findAll(): List<EducationalInstitutionResponse> {
        return educationalInstitutionService.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): EducationalInstitutionResponse {
        val educationalInstitution = educationalInstitutionService.findById(id)
            ?: throw Exception("Educational institution with id $id not found")
        return educationalInstitution.toResponse()
    }

    @PostMapping
    fun create(@RequestBody request: EducationalInstitutionRequest): EducationalInstitutionResponse {
        val educationalInstitution = request.toEntity()
        val savedEducationalInstitution = educationalInstitutionService.save(educationalInstitution)
        return savedEducationalInstitution.toResponse()
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: EducationalInstitutionRequest
    ): EducationalInstitutionResponse {
        val educationalInstitution = educationalInstitutionService.findById(id)
            ?: throw Exception("Educational institution with id $id not found")
        val updatedEducationalInstitution = educationalInstitutionService.save(educationalInstitution)
        return updatedEducationalInstitution.toResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        educationalInstitutionService.deleteById(id)
    }

    private fun EducationalInstitutionRequest.toEntity() = EducationalInstitution(
        name = name,
        accreditationLevel = accreditationLevel,
        address = address,
        foundationDate = foundationDate,
        numberOfFaculties = numberOfFaculties,
        website = website,
        militaryDepartment = militaryDepartment,
        disciplines = emptyList()
    )

    private fun EducationalInstitution.toResponse() = EducationalInstitutionResponse(
        id = id,
        name = name,
        accreditationLevel = accreditationLevel,
        address = address,
        foundationDate = foundationDate,
        numberOfFaculties = numberOfFaculties,
        website = website,
        militaryDepartment = militaryDepartment
    )
}
