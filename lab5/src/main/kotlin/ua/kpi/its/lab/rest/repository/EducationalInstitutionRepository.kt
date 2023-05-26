package ua.kpi.its.lab.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.rest.entity.EducationalInstitution

interface EducationalInstitutionRepository : JpaRepository<EducationalInstitution, Long> {
    // тут можна додати додаткові методи пошуку
}
