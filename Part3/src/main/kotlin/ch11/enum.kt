package ch11

// enum 상수는 enum 클래스를 상속받은 하위클래스의 객체라는 개념!
enum class Direction {
    NORTH {
        override val foo: Int = 10
        override fun bar() {
            println("North bar! $foo, $foh")
        }
        fun baz() { }
        val foh: Int = 20
    },
    SOUTH {
        override val foo: Int = 20
        override fun bar() {
            println("North bar! $foo")
        }

    }; // 코틀린에서 유일하게 세미콜론(;)을 강제
    abstract val foo: Int
    abstract fun bar()
}

fun main(args: Array<String>) {
    val data: Direction = Direction.NORTH
    data.bar()
}