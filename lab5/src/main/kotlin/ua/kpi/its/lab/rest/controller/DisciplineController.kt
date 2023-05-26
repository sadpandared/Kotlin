package ua.kpi.its.lab.rest.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.DisciplineRequest
import ua.kpi.its.lab.rest.dto.DisciplineResponse
import ua.kpi.its.lab.rest.entity.Discipline
import ua.kpi.its.lab.rest.svc.DisciplineService

@RestController
@RequestMapping("/disciplines")
class DisciplineController @Autowired constructor(
    private val disciplineService: DisciplineService
) {
    @GetMapping
    fun findAll(): List<DisciplineResponse> {
        return disciplineService.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): DisciplineResponse {
        val discipline = disciplineService.findById(id)
            ?: throw Exception("Discipline with id $id not found")
        return discipline.toResponse()
    }

    @PostMapping
    fun create(@RequestBody request: DisciplineRequest): DisciplineResponse {
        val discipline = request.toEntity()
        val savedDiscipline = disciplineService.save(discipline)
        return savedDiscipline.toResponse()
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: DisciplineRequest
    ): DisciplineResponse {
        val discipline = disciplineService.findById(id)
            ?: throw Exception("Discipline with id $id not found")
        val updatedDiscipline = disciplineService.save(discipline)
        return updatedDiscipline.toResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        disciplineService.deleteById(id)
    }

    private fun DisciplineRequest.toEntity() = Discipline(
        name = name,
        institution = institution,
        specialtyCode = specialtyCode,
        semester = semester,
        numberOfHours = numberOfHours,
        approvalDate = approvalDate,
        exam = exam,
        educationalInstitution = null
    )

    private fun Discipline.toResponse() = DisciplineResponse(
        id = id,
        name = name,
        institution = institution,
        specialtyCode = specialtyCode,
        semester = semester,
        numberOfHours = numberOfHours,
        approvalDate = approvalDate,
        exam = exam
    )
}
