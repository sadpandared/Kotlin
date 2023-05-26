package ua.kpi.its.lab.rest.svc.impl

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.entity.EducationalInstitution
import ua.kpi.its.lab.rest.repository.EducationalInstitutionRepository
import ua.kpi.its.lab.rest.svc.EducationalInstitutionService

@Service
class EducationalInstitutionServiceImpl(
    private val educationalInstitutionRepository: EducationalInstitutionRepository
) : EducationalInstitutionService {

    @PreAuthorize("hasRole('EDITOR') or hasRole('USER')")
    override fun findAll(): List<EducationalInstitution> {
        return educationalInstitutionRepository.findAll()
    }

    @PreAuthorize("hasRole('EDITOR') or hasRole('USER')")
    override fun findById(id: Long): EducationalInstitution? {
        return educationalInstitutionRepository.findById(id).orElse(null)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun save(educationalInstitution: EducationalInstitution): EducationalInstitution {
        return educationalInstitutionRepository.save(educationalInstitution)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun deleteById(id: Long) {
        educationalInstitutionRepository.deleteById(id)
    }
}
