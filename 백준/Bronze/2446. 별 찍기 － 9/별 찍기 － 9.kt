import java.util.*;

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    for (i in 1..n) {
        for (j in 1 until i) print(" ")
        for (j in 2 * n - i downTo i) print("*")
        println()
    }
    for (i in 1..(n - 1)) {
        for (j in n - 1 downTo i + 1) print(" ")
        for (j in 1 until 2 * (i + 1)) print("*")
        println()
    }
}