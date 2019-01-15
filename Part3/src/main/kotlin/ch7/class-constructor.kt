package ch7

/*
객체 생성시 받아야 하는 필수 데이터를 주 생성자로
부 데이터를 보조 생성자로
부에서 주 연결로
 */

class User(val id: String, val name: String) {
    var email: String? = null
    constructor(id: String, name: String, email: String) : this(id, name) {
        println("constructor")
        this.email = email
    }

    init {
        println("init... name: ${name}, id: ${id}")
    }

    fun hello() {
        println("Hello, $name! id: $id, email: $email")
    }
}

fun main(args: Array<String>) {
    val jane = User("0", "Jane")
    jane.hello()
    val shawn = User("1", "shawn", "s.shin@marathoner.kr")
    shawn.hello()
}
