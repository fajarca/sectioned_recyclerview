package io.fajarca.project.sectionedrecyclerview.data

object DataStore {
    fun populateData(): List<RecyclerViewSection> {
        val sections = mutableListOf<RecyclerViewSection>()

        repeat(5) {
            val items = mutableListOf<String>()

            repeat(10) {
                items.add("Item $it")
            }

            val section = RecyclerViewSection("Section $it", items)
            sections.add(section)
        }

        return sections
    }
}