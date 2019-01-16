package ch11

// 일반 클래스 작성방법
class User(val no: Int, val name: String)
data class UserVO(val no: Int, val name: String) {
    var email: String? = null
    constructor(no: Int, name: String, email: String) : this(no, name) {
        this.email = email
    }
}

fun main(args: Array<String>) {
    val user1 = User(1, "hello")
    val user2 = User(1, "hello")
    val user3 = UserVO(1, "hello")
    val user4 = UserVO(1, "hello")

    println("${user1.equals(user2)}, ${user3.equals(user4)}, ${user1.equals(user3)},") // false, true, false

    val user5 = UserVO(1, "hello", "bar@abc.com")
    val user6 = UserVO(1, "hello", "foo@abc.com")

    println("${user5.equals(user6)}, ${user5.equals(user3)}") // true, true -> 주 생성자 프로퍼티만 비교

    println("${user1 == user2}, ${user1 === user2}, ${user3 == user4}, ${user3 === user4} ${user5 == user6}")

    println("${user1.toString()} ${user3.toString()} ${user5.toString()}")

    // 멤버 접근(비구조화 할당)
    val no1 = user3.component1()
    val name1 = user3.component2()
    println("user3 -> no: $no1, name: $name1")

    // 변수명으로 하는게 아니라 변수 선언 순서로 나옴
    val (notName, notNo) = user5
    println("user5 -> no: $notName, name: $notNo")

    // underscore(_) 획득하고 싶지 않은 데이터를 명시적으로 선언
    val (_, a) = user3

    // list에도 사용 가능
    val list = listOf(1, 2, 3, 4)
    val (d1, d2) = list
    println("$d1 $d2")


    // 튜플과 유사하게
    data class Tuple(val el1: Int, val el2: Int, val el3: Int)
    fun getDatas(): Tuple {
        return Tuple(1, 2, 3)
    }
    val (c1, c2, c3) = getDatas()
}