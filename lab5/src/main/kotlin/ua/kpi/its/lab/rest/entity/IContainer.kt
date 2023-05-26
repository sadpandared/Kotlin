package ua.kpi.its.lab.rest.entity

interface IContainer<T> {
    /**
     * Додає елемент до контейнера.
     * @param item Елемент, який потрібно додати.
     */
    fun add(item: T)

    /**
     * Видаляє елемент з контейнера за індексом.
     * @param index Індекс елемента, який потрібно видалити.
     */
    fun removeAt(index: Int)

    /**
     * Оновлює елемент у контейнері за індексом.
     * @param index Індекс елемента, який потрібно оновити.
     * @param item Новий елемент.
     */
    fun updateAt(index: Int, item: T)

    /**
     * Отримує елемент з контейнера за індексом.
     * @param index Індекс елемента, який потрібно отримати.
     * @return Елемент за вказаним індексом.
     */
    fun getAt(index: Int): T

    /**
     * Отримує всі елементи з контейнера.
     * @return Список всіх елементів у контейнері.
     */
    fun getAll(): List<T>
}