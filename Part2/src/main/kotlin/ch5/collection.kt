package ch5

import java.util.*

fun main(args: Array<String>) {
    // 배열
    arrayOf(10, 20, "hello") // Array<Any>
    arrayOf<Int>(1, 2, 3)
    intArrayOf(1, 2, 3)

    // 사이즈 선언 및 초기값
    Array<Int>(3, { 0 }) // 초기값이 0인 사이즈 3의 배열 생성
    IntArray(3, { 0 })   //.동일
    arrayOfNulls<Int>(2) // null로 초기화되는 정수 배열
    IntArray(2) // 0으로 초기화

    // 2차원 배열
    var arr = Array<IntArray>(2, { IntArray(3) }) // 2*3 배열
    arr[1][2] = 3

    println(Arrays.deepToString(arr))


    // List
    val list = listOf<Int>(1, 2, 3)
    //list.add(!0) // error, immutable
    val list1 = mutableListOf<Int>(1, 2)
    list1.add(3)
    list1.forEach { println(it) }

    // Map
    val map = mapOf<String, Any>(Pair("one", "hello"), Pair("two", 2))
    println("${map.get("one")}")
    println("${map.get("two")}")

    val map2 = mapOf<String, Any>("one" to "hello", "two" to 2) // 위 데이터와 동일
    val iterator: Iterator<Map.Entry<String, Any>> =
            map2.iterator()

    while(iterator.hasNext()) {
        val entry = iterator.next()
        println("${entry.key} - ${entry.value}")
    }
}