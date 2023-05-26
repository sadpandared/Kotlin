package ua.kpi.its.lab.rest.repository

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.rest.entity.Discipline

interface DisciplineRepository : JpaRepository<Discipline, Long> {
    // тут можна додати додаткові методи пошуку
}
