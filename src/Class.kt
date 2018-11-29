import java.util.*
import kotlin.math.abs
import kotlin.math.max

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
    println(Arrays.deepToString(arrayOf(seven(921))))

    //sum only positive
    println(sum(intArrayOf(12, 3, 65, -34, 3, -1)))

    /*I have a cat and a dog.
    I got them at the same time as kitten/puppy. That was humanYears years ago.
    Return their respective ages now as [humanYears,catYears,dogYears]

    NOTES:

        humanYears >= 1
        humanYears are whole numbers only

    Cat Years

        15 cat years for first year
        +9 cat years for second year
        +4 cat years for each year after that

    Dog Years

        15 dog years for first year
        +9 dog years for second year
        +5 dog years for each year after that*/
    println(Arrays.deepToString(calculateYears(10)))

    /*Write a function called repeatStr which repeats the given string string exactly n times.*/
    println(repeatStr(4, "fuck"))

    //return shortest word of the sentence
    println(findShort("turns out random test cases are easier than writing out basic ones"))

    /*You will be given a string (x) featuring a cat 'C' and a mouse 'm'. The rest of the string will be made up of '.'.
    You need to find out if the cat can catch the mouse from it's current position. The cat can jump over three characters. So:
    C.....m returns 'Escaped!' <-- more than three characters between
    C...m returns 'Caught!' <-- as there are three characters between the two, the cat can jump.*/
    println(catMouse("C....m"))
    println(catMouse("C...m"))
    println(catMouse("C..m"))

    /*You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any string in the first array and y be any string in the second array.
    Find max(abs(length(x) − length(y)))
    If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).*/
    val s1 = arrayOf(
        "hoqq",
        "bbllkw",
        "oox",
        "ejjuyyy",
        "plmiis",
        "xxxzgpsssa",
        "xxwwkktt",
        "znnnnfqknaz",
        "qqquuhii",
        "dvvvwz"
    )
    val s2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
    println(mxdiflg(s1, s2))

    //check if all values of array ar less then limit
    println(smallEnough(intArrayOf(101, 45, 75, 105, 99, 107), 107))

    //Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
    println(replace("aeiou"))
    println(replace("ABCDE"))

    /*Move every letter in the provided string forward 10 letters through the alphabet.
    If it goes past 'z', start again at 'a'.*/
    println(moveTen("testcase"))
}

fun moveTen(s: String) = s.map { if (it < 'q') it + 10 else it - 16 }.joinToString("")

/*fun replace(s: String) = s.replace('a', '!', true)
        .replace('e', '!', true)
        .replace('i', '!', true)
        .replace('o', '!', true)
        .replace('u', '!', true)*/
fun replace(s: String) = s.replace(Regex("[aeiou]", RegexOption.IGNORE_CASE), "!")

//fun smallEnough(a : IntArray, limit : Int) = !(a.map { it <= limit }.contains(false))
//fun smallEnough(a: IntArray, limit: Int) = a.all { it <= limit }
fun smallEnough(a: IntArray, limit: Int) = a.none { it > limit }

/*fun repeatStr(r: Int, str: String) = r.let {
    var result = ""
    for (i in 1..r)
        result += str
    return@let result
}*/
fun repeatStr(r: Int, str: String) = str.repeat(r)

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
    if (a1.isEmpty() || a2.isEmpty()) return -1
    val isA1Larger = a1.size > a2.size
    val largestArr = if (isA1Larger) a1 else a2
    val smallestArr = if (isA1Larger) a2 else a1

    var largest = 0
    for (str1 in smallestArr) {
        for (str2 in largestArr) {
            val maxStr = abs(str1.length - str2.length)
            largest = max(largest, maxStr)
        }
    }
    return largest
}

fun printMaxMinString(str: String) =
    str
        .trim()
        .split(' ')
        .map(String::toInt)
        .let {
            println("${it.max()} ${it.min()}")
        }

fun catMouse(s: String) = if (s.indexOf('m') > s.indexOf('C') + 4) "Escaped!" else "Caught!"

fun findShort(s: String) = s.trim().split(' ').minBy { it.length }

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

fun sum(numbers: IntArray): Int = numbers.filter { it > 0 }.sum()

fun calculateYears(years: Int): Array<Int> {
    var catYears = 0
    var dogYears = 0

    for (i in 1..years) {
        if (i == 1) {
            catYears += 15
            dogYears += 15
            continue
        }
        if (i == 2) {
            catYears += 9
            dogYears += 9
            continue
        }
        catYears += 4
        dogYears += 5
    }
    return arrayOf(years, catYears, dogYears)
}