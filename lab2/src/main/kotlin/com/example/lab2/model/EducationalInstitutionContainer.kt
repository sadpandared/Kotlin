package com.example.lab2.model

import EducationalInstitution
import com.example.lab2.model.IContainer
import org.springframework.stereotype.Component

@Component
abstract class EducationalInstitutionContainer : IContainer<EducationalInstitution> {
    private val list = ArrayList<EducationalInstitution>()

    override fun add(item: EducationalInstitution) {
        list.add(item)
    }

    override fun removeAt(index: Int) {
        list.removeAt(index)
    }

    override fun updateAt(index: Int, item: EducationalInstitution) {
        list[index] = item
    }

    override fun getAt(index: Int): EducationalInstitution {
        return list[index]
    }

    override fun getAll(): List<EducationalInstitution> {
        return list.toList()
    }
}