lateinit var list: MutableList<MutableList<Int>>
lateinit var visit: Array<Boolean>
var sum: Int = 0

fun main(args: Array<String>) {
    val N = readln().toInt()
    list = ArrayList()
    for (i in 0..N) {
        list.add(ArrayList())
    }
    repeat(N - 1) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        list.get(x).add(y)
        list.get(y).add(x)
    }

    sum = 0
    visit = Array(N + 1) { false }
    dfs(1, 0)

    if (sum % 2 == 0) {
        println("No")
    } else {
        println("Yes")
    }

}

fun dfs(start: Int, routes: Int) {
    visit[start] = true
    var flag = false
    for (next in list.get(start)) {
        if (!visit[next]) {
            flag = true
            dfs(next, routes + 1)
        }
    }

    if (!flag) {
        sum += routes
    }
}