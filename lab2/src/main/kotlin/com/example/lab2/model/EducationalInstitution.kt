
data class EducationalInstitution(
    val name: String,
    val accreditationLevel: Int,
    val address: String,
    val foundationDate: String,
    val numberOfFaculties: Int,
    val website: String,
    val militaryDepartment: Boolean,
    val disciplines: List<Discipline>
) : Comparable<EducationalInstitution> {
    override fun compareTo(other: EducationalInstitution): Int {
        // First compare by accreditationLevel (higher is better)
        val accreditationComparison = other.accreditationLevel.compareTo(accreditationLevel)
        if (accreditationComparison != 0) return accreditationComparison

        // If accreditationLevels are equal, compare by name
        return name.compareTo(other.name)
    }
}


