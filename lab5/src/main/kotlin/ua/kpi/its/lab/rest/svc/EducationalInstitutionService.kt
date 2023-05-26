package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.entity.EducationalInstitution

interface EducationalInstitutionService {
    fun findAll(): List<EducationalInstitution>
    fun findById(id: Long): EducationalInstitution?
    fun save(discipline: EducationalInstitution): EducationalInstitution
    fun deleteById(id: Long)
}
