import java.util.*;

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    var n = s.nextInt()
    for (i in 1..n) {
        for (j in 0 until i) print("*")
        for (j in 0 until 2 * (n - i)) print(" ");
        for (j in 0 until i) print("*")
        println()
    }
    for (i in n - 1 downTo 1) {
        for (j in 0 until i) print("*");
        for (j in 0 until 2 * (n - i)) print(" ");
        for (j in 0 until i) print("*")
        println()
    }
}