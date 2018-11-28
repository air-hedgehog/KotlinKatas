fun main(args: Array<String>) {

    //return string of max and min value of string of numbers
    val str: String = "12 5 6 7 8 9 -5 -6 -78 56 "
    printMaxMinString(str)

    /*
    Number of people in the bus

    There is a bus moving in the city, and it takes and drop some people in each bus stop.
    You are provided with a list (or array) of integer arrays (or tuples). Each integer array has two items which represent number of people get into bus (The first item) and number of people get off the bus (The second item) in a bus stop.
    Your task is to return number of people who are still in the bus after the last bus station (after the last array). Even though it is the last bus stop, the bus is not empty and some people are still in the bus, and they are probably sleeping there :D
    Take a look on the test cases.
    Please keep in mind that the test cases ensure that the number of people in the bus is always >= 0. So the return integer can't be negative.
    The second value in the first integer array is 0, since the bus is empty in the first bus stop.*/
    println(people(arrayOf(3 to 0, 9 to 1, 4 to 10, 12 to 2, 6 to 1, 7 to 10)))

    /*
    A number m of the form 10x + y is divisible by 7 if and only if x − 2y is divisible by 7. In other words,
    subtract twice the last digit from the number formed by the remaining digits. Continue to do this until a number
    known to be divisible or not by 7 is obtained; you can stop when this number has at most 2 digits because you are
    supposed to know if a number of at most 2 digits is divisible by 7 or not.

    The original number is divisible by 7 if and only if the last number obtained using this procedure is divisible by 7.

    Examples:
    1 - m = 371 -> 37 − (2×1) -> 37 − 2 = 35 ; thus, since 35 is divisible by 7, 371 is divisible by 7.
    The number of steps to get the result is 1.
    2 - m = 1603 -> 160 - (2 x 3) -> 154 -> 15 - 8 = 7 and 7 is divisible by 7.
    3 - m = 372 -> 37 − (2×2) -> 37 − 4 = 33 ; thus, since 33 is not divisible by 7, 372 is not divisible by 7.
    The number of steps to get the result is 1.
    4 - m = 477557101->47755708->4775554->477547->47740->4774->469->28 and 28 is divisible by 7, so is 477557101.
    The number of steps is 7.
    #Task: Your task is to return to the function seven(m) (m integer >= 0) an array (or a pair, depending on the language)
    of numbers, the first being the last number m with at most 2 digits obtained by your function (this last m will be
    divisible or not by 7), the second one being the number of steps to get the result.*/
    for (i: Long in seven(921))
        println(i)
}

fun printMaxMinString(str: String) =
    str
        .trim()
        .split(' ')
        .map(String::toInt)
        .let {
            println("${it.max()} ${it.min()}")
        }

fun people(busStops: Array<Pair<Int, Int>>) = busStops.sumBy { it.first - it.second }

/*
fun seven(n: Long): LongArray {
    val digitsCount = getDigitsCount(n)
    if (digitsCount <= 2) return longArrayOf(n, 0)

    var iterations = 0

    var lastDigit = n % 10
    var remainingValue = n / 10
    for (i in 0..digitsCount) {
        iterations++

        if (getDigitsCount(remainingValue) <= 2)
            return longArrayOf(remainingValue - 2 * lastDigit, iterations.toLong())

        remainingValue -= 2 * lastDigit
        lastDigit = remainingValue % 10
        remainingValue /= 10
    }

    return longArrayOf(0, 0)
}

fun getDigitsCount(value: Long): Int {
    var result = 0
    var tmpValue = value
    while (tmpValue != 0.toLong()) {
        tmpValue /= 10.toLong()
        result++
    }
    return result
}*/

fun seven(n: Long, i: Long = 0): LongArray =
    if (n > 99)
        seven(n / 10 - n % 10 * 2, i + 1)
    else
        longArrayOf(n, i)