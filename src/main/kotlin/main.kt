const val DAY = 86400
const val HOUR = 3600
const val MINUTE = 60

fun main(){
    val timeFromLastVisit = MINUTE*2

    println("был(а) " + agoToText(timeFromLastVisit))
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0 .. MINUTE -> "только что" //если меньше минуты
        in MINUTE+1 .. HOUR -> "${time/MINUTE} ${minuteToText(time/MINUTE)} назад"
        in HOUR+1 .. DAY -> "${time/HOUR} ${hoursToText(time/HOUR)} назад"
        in DAY+1 .. DAY*2 -> "сегодня"
        in DAY*2+1 .. DAY*3 -> "вчера"
        else -> "давно"
    }
}

fun minuteToText(minuteFromLastVisit: Int): String {
    return when(minuteFromLastVisit){
        1, 21, 31, 41, 51 -> "минуту"
        in 2 .. 4 -> "минуты"
        else -> "минут"
    }
}

fun hoursToText(hoursFromLastVisit: Int): String {
    return when(hoursFromLastVisit){
        1, 21 -> "час"
        in 2 .. 4 -> "часа"
        else -> "часов"
    }
}
