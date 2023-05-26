data class Discipline (
    val name: String,
    val institution: String,
    val specialtyCode: String,
    val semester: Int,
    val numberOfHours: Int,
    val approvalDate: String,
    val exam: Boolean
) : Comparable<Discipline> {
    override fun compareTo(other: Discipline): Int {
        // Порівнюємо спочатку за назвою
        val nameComparison = name.compareTo(other.name)
        if (nameComparison != 0) return nameComparison

        // Якщо назви однакові, порівнюємо за кількістю годин
        return numberOfHours.compareTo(other.numberOfHours)
    }
}