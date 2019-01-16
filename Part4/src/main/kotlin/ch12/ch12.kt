package ch12

fun foo(calc: (a: Int, b: Int) -> Int) {
    calc(10, 20)
}

// data filtering 하는 함수
// 필터링 조건은 매개변수 함수로 전달
// 그 함수를 호출해서 true를 리턴하는 데이터만 넘겨줏마
fun filter(list: List<Int>, foo: (Int) -> Boolean): List<Int> {
    var resultList = mutableListOf<Int>()

    for(i: Int in list) {
        if(foo(i)) {
            resultList.add(i)
        }
    }

    return resultList
}

fun main(args: Array<String>) {
    println("${foo { x, y -> x + y } }")

    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7)

    println("even -> ${filter(numbers) { it%2 == 0 } }")

    testRun()
    testCurrying()
}

fun testRun() {
    // run
    class User {
        var name = "kim"
        fun hello() {
            println("hello world")
        }
    }

    val shawn = User()
    val result = shawn.run {
        name = "Shawn"
        hello()
        0
    }

    println("${shawn.name} - $result")
}

fun testCurrying() {
    // currying
    // 분리된 함수 재사용 용이
    // 비동기 환경에서 로직 구현 용이
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    println("result: ${add(1, 2)}")

    fun curryingAdd(a: Int): (Int) -> Int {
        return fun(b: Int): Int {
            return a + b
        }
    }
    println("result: ${curryingAdd(1)(2)}")

    // shorthand
    fun foo(a: Int) = fun(b: Int): Int {
        return a + b
    }

    println(foo(10)(2))

    // shorthand2
    fun bar(a: Int) = {b: Int -> a + b}
    println(bar(10)(2))

    // 복잡하게?
    fun baz(a: Int, b: Int, c: Int, d: Int): Int {
        return a + b + c + d
    }

    fun baz(a: Int) = { b: Int -> { c: Int -> { d: Int -> a + b + c + d }}}
}