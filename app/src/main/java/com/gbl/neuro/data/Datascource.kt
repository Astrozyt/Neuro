package com.gbl.neuro.data

import com.gbl.neuro.model.Recording

class Datasource() {
    fun loadRecordings(): List<Recording> {
        return listOf<Recording>(
            Recording(
                id = 1,
                name = "Recording 1",
                duration = 60,
                date = "2021-01-01",
                location = "Location 1",
                description = "Description 1",
                rating = 1,
                image = "https://images.unsplash.com/photo-1612835362596-4b0b2a2b0b0f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2hha2VyJTIwYmFja2dyb3VuZCUyMHN0b3JlJTIwYmVzdCUyMHN0b3J5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"
            ),
            Recording(
                id = 2,
                name = "Recording 2",
                duration = 60,
                date = "2021-01-01",
                location = "Location 2",
                description = "Description 2",
                rating = 2,
                image = "https://images.unsplash.com/photo-1612835362596-4b0b2a2b0b0f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2hha2VyJTIwYmFja2dyb3VuZCUyMHN0b3JlJTIwYmVzdCUyMHN0b3J5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"
            ),
            Recording(
                id = 3,
                name = "Recording 3",
                duration = 60,
                date = "2021-01-01",
                location = "Location 3",
                description = "Description 3",
                rating = 3,
                image = "https://images.unsplash.com/photo-1612835362596-4b0b2a2b0b0f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2hha2VyJTIwYmFja2dyb3VuZCUyMHN0b3JlJTIwYmVzdCUyMHN0b3J5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"
            ),
            Recording(
                id = 4,
                name = "Recording 4",
                duration = 60,
                date = "2021-01-01",
                location = "Location 4",
                description = "Description 4",
                rating = 4,
                image = "https://images.unsplash.com/photo-1612835362596-4b0b2a2b0b0f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2hha2VyJTIwYmFja2dyb3VuZCUyMHN0b3JlJTIwYmVzdCUyMHN0b3J5fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&w=1000&q=80"
            ),
        )
    }
}