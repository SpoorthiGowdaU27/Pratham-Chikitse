package com.pratham.chikitse.data

data class Hospital(
    val name: String,
    val type: String,
    val distanceKm: String,
    val phone: String,
    val isOpen24x7: Boolean
)

object HospitalRepository {
    val hospitals = listOf(
        Hospital(
            name = "District Hospital, Ramanagara",
            type = "Government",
            distanceKm = "2.4",
            phone = "108",
            isOpen24x7 = true
        ),
        Hospital(
            name = "Srinivasa Nursing Home",
            type = "Private",
            distanceKm = "3.8",
            phone = "108",
            isOpen24x7 = true
        ),
        Hospital(
            name = "PHC Bidadi",
            type = "Primary Health Centre",
            distanceKm = "5.1",
            phone = "108",
            isOpen24x7 = false
        )
    )
}
