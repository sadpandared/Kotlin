package com.example.lab2
import AppConfig
import Discipline
import EducationalInstitution
import com.example.lab2.model.DisciplineContainer
import com.example.lab2.model.IContainer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class Lab2Application

fun main(args: Array<String>) {
	runApplication<Lab2Application>(*args)
	// Створюємо AnnotationConfigApplicationContext
	val context = AnnotationConfigApplicationContext(AppConfig::class.java)

	// Отримуємо компонент (клас-контейнер) по його інтерфейсу
	val disciplineContainer = context.getBean(IContainer::class.java) as DisciplineContainer

	// Створюємо 5 різноманітних сутностей Discipline
	val discipline1 = Discipline(
		name = "Mathematics",
		institution = "University A",
		specialtyCode = "01",
		semester = 1,
		numberOfHours = 60,
		approvalDate = "2022-01-01",
		exam = true
	)
	val discipline2 = Discipline(
		name = "Physics",
		institution = "University B",
		specialtyCode = "02",
		semester = 2,
		numberOfHours = 80,
		approvalDate = "2022-02-01",
		exam = true
	)
	val discipline3 = Discipline(
		name = "Chemistry",
		institution = "University C",
		specialtyCode = "03",
		semester = 3,
		numberOfHours = 70,
		approvalDate = "2022-03-01",
		exam = false
	)
	val discipline4 = Discipline(
		name = "Biology",
		institution = "University D",
		specialtyCode = "04",
		semester = 4,
		numberOfHours = 50,
		approvalDate = "2022-04-01",
		exam = true
	)
	val discipline5 = Discipline(
		name = "Computer Science",
		institution = "University E",
		specialtyCode = "05",
		semester = 5,
		numberOfHours = 90,
		approvalDate = "2022-05-01",
		exam = false
	)

	// Використовуючи методи класу-контейнера додаємо ці 5 сутностей в список
	disciplineContainer.add(discipline1)
	disciplineContainer.add(discipline2)
	disciplineContainer.add(discipline3)
	disciplineContainer.add(discipline4)
	disciplineContainer.add(discipline5)

	// Отримуємо сутність з індексом 3
	val thirdDiscipline=disciplineContainer.getAt(3)
	println("Third discipline:$thirdDiscipline")

	// Видаляємо сутність з індексом 4
	disciplineContainer.removeAt(4)

	// Отримуємо всі елементи з контейнера після видалення
	val allDisciplinesAfterRemoval = disciplineContainer.getAll()
	println("All disciplines after removal:$allDisciplinesAfterRemoval")

	// Створюємо об'єкт EducationalInstitution.kt, у якого disciplines буде списком усіх дисциплін, які були створені
	val educationalInstitution =
		EducationalInstitution(
			name = "University A",
			accreditationLevel = 1,
			address = "Address A",
			foundationDate = "1900",
			numberOfFaculties = 10,
			website = "www.universityA.com",
			militaryDepartment = true,
			disciplines = listOf())

	println("Educational Institution:$educationalInstitution")
}
