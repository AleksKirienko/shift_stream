fun main() {
    val cityName = getCity()
    println("В городе ${cityName}е сейчас жарко")
    val temperature = getTemperature()
    val weather = City(cityName, temperature)
    println(getWeatherTemp(weather))
}

private fun getCity(): String {
    println("Привет! В каком городе ты живёшь?")
    return readLine() ?: throw error("Введите название города")
}

private fun getTemperature(): Int {
    println("Сколько градусов?")
    return readLine()?.toIntOrNull() ?: throw error("Введите возраст  в виде числа")
}

fun getWeatherTemp(city: City) : String =
    when (city.temperature) {
        in -50..15 -> "Холодно"
        in 15..25 -> "Нормально"
        in 25..50 -> "Жарко"
        else -> "При такой температуре не живут"
    }
