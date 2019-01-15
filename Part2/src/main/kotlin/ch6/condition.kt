package ch6

fun main(args: Array<String>) {
    ifTest(10)
    testForStatement()
    equityTest()
}

fun ifTest(arg: Int) {
    // 코틀린에서 if문은 expression으로 사용 가능
    // 실행 결과가 발생하기 때문에 변수에 대입 가능
    var result = if(arg > 10) {
        println("arg>10")
        arg // `return`은 사용하지 않음
    } else if(arg > 100) {
        println("arg>100")
        100
    } else {
        0
    }
    println("result: $result")
}

fun testForStatement() {
    println("===downTo===")
    for(i in 10 downTo 1 step 2) {
        println(i)
    }

    println("===array===")
    val array = arrayOf("hello", "world")
    for((index, value) in array.withIndex()) {
        println("index: $index, value: $value")
    }

    println("===map===")
    val map = mapOf("one" to "hello", "two" to "world")
    for(item in map) {
        println("key: ${item.key}, val: ${item.value}")
    }
}

fun equityTest() {
    // 일반 객체는 `?`에 의한 boxing 효과가 없으며, `==`, `===` 모두 객체비교이다.

    class User
    val user1 = User()
    val user2 = User()
    val user3:User? = User()
    val user4 = user1
    println("${user1 == user2}, ${user1 === user2}, ${user1 == user3}, ${user1 == user4}") // false, false, false, true

    /*
    기초 데이터 타입의 객체들은 `?`에 의해 boxing 효과
    Int -> int
    Int? -> Integer
     */
    val no1 = 1000
    val no2 = 1000
    val no3: Int? = 1000
    println("${no1 == no2}, ${no1 === no2}, ${no1 == no3}, ${no1 === no3}") // true, true, true, false

    // Integer -128 ~ 127 값은 컴파일러에 의해서 캐싱되기 때문에 객체비교도 true
    val cache1 = 127
    val cache2 = 127
    val cache3:Int? = 127
    println("${cache1 == cache2}, ${cache1 === cache2}, ${cache1 == cache3}, ${cache1 === cache3}") // true, true, true, false
}
