package ua.kpi.its.lab.rest.svc.impl

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.entity.Discipline
import ua.kpi.its.lab.rest.repository.DisciplineRepository
import ua.kpi.its.lab.rest.svc.DisciplineService

@Service
class DisciplineServiceImpl(
    private val disciplineRepository: DisciplineRepository)
: DisciplineService {

    @PreAuthorize("hasRole('EDITOR') or hasRole('USER')")
    override fun findAll(): List<Discipline> {
        return disciplineRepository.findAll()
    }

    @PreAuthorize("hasRole('EDITOR') or hasRole('USER')")
    override fun findById(id: Long): Discipline {
        return disciplineRepository.findById(id).orElse(null)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun save(discipline: Discipline): Discipline {
        return disciplineRepository.save(discipline)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun deleteById(id: Long) {
        disciplineRepository.deleteById(id)
    }
}
