package ua.kpi.its.lab.rest.entity
import org.springframework.stereotype.Component

@Component
class DisciplineContainer : IContainer<Discipline> {
    private val list = ArrayList<Discipline>()

    override fun add(item: Discipline) {
        list.add(item)
    }

    override fun removeAt(index: Int) {
        list.removeAt(index)
    }

    override fun updateAt(index: Int, item: Discipline) {
        list[index] = item
    }

    override fun getAt(index: Int): Discipline {
        return list[index]
    }

    override fun getAll(): List<Discipline> {
        return list.toList()
    }
}