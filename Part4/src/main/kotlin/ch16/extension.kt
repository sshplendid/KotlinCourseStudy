package ch16

class User {
    val foo = 10
    fun bar() {
        println("user bar... ${foo} ${foz}") // extension으로 추가한 멤버 접근 가능한가?

    }
}

// property 추가
// 컴파일 시 클래스 외부에 정적 등록
// 매개변수로 절달된 receiver 클래스 객체로 이용되는 구조
// backing field를 만들지 않음

val User.foz
        get() = 20

fun User.baz() {
    println("baz... ${foo}, ${foz}")
}

// String index 위치 구하는 모든 위치..?
fun String.indexOfAll(arg: String): List<Int> {
    val list = mutableListOf<Int>()
    var pos = this.indexOf(arg)
    while(pos > -1) {
        list.add(pos)
        pos = this.indexOf(arg, pos + 1)
    }

    return list
}

fun main(args: Array<String>) {
    val foo = User()
    foo.bar()
    foo.baz()

    testIndexOfAll()
}

fun testIndexOfAll() {
    val str = "hello world"
    str.indexOfAll("l").map {it.toString()}.reduce { a, b -> a + " " + b }.let { println("indices of l... ${it}") }
}