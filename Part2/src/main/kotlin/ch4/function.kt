package ch4

fun sum(start: Int = 1, end: Int = 10, result: Int = 0): Int {
    if(start > end) {
        return result
    } else {
        return sum(start + 1, end, result + start)
    }
}

tailrec fun sum2(start: Int = 1, end: Int = 10, result: Int = 0): Int {
    if(start > end) {
        return result
    } else {
        return sum2(start + 1, end, result + start)
    }
}

fun main(args: Array<String>) {
    fun foo(arg1: Int, arg2: String = "Shawn") = println("arg1: $arg1, arg2: $arg2")

    foo(10)
    foo(10, "Jane")
    foo(arg2 = "Kane", arg1 = -1)

    // 가변인수
    fun varargFun(arg1: Int, vararg args: Int) {
        for(a in args) {
            print("args: $a")
        }

        if(args.size > 0) {
            println(args[0])
        }
    }

    varargFun(10)
    varargFun(10, 20, 30, 40, 50)



    println("result: ${sum(end=10)}")
    println("result: ${sum2()}")
}
