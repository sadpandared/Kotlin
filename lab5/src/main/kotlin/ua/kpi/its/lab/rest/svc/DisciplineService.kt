package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.entity.Discipline

interface DisciplineService {
    fun findAll(): List<Discipline>
    fun findById(id: Long): Discipline?
    fun save(discipline: Discipline): Discipline
    fun deleteById(id: Long)
}
