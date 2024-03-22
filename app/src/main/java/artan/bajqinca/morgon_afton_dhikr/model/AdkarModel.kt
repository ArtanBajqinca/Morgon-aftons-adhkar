package artan.bajqinca.morgon_afton_dhikr.model

data class AdkarModel(
    val id: Int,
    val sv: String,
    val ar: String,
    val en: String,
    val transliteration: String,
    val source: String,
    val reward: String,
    val repetition: Int = 0,
    val svKapitel: String = "",
    val arKapitel: String = "",
    val repetitionText: String = "",
    val repetitionTextArabic: String = "",
)