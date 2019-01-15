package ch8

fun main(args: Array<String>) {
   var obj = User()
    obj.id = 10
    obj.name = "Shawn"
    println(obj)

    var obj1 = MyClass()
    println("object created...")
    println("obj1.data5: ${obj1.data5}")
}

// accessor
class User {
    // Kotlin에서의 변수는 property, accessor(get, set)을 내장한 변수이다. 개발자에 의해 custom accessor 추가 가능
    var id: Int = 0
        set(value) {
            if(value < 0) field = 0 // field는 프로퍼티 값에 접근하기 위한 예약어
            else field = value
        }
    var name: String? = null
        get() = field?.toUpperCase() // null-safety, `null`이면 null 리턴, 아니면 뒷 멤버 접근..........

    override fun toString(): String {
        return "id: ${id}, name: ${name}"
    }
}

// custom accessor 추가 가능하지만, 만약 accessor에서 field를 사용하지 않으면
// java 변환할 때 변수가 만들어지지 않는다.
// getData()라는 함수만 추가됨
// val data : String = "hello" // [1] error
val data: String
    get() = "world"

/*
var data3: String = "aaa"
    get() = "Kim"
set(value) {
    data3 = value
}
*/

// 초기화 미루기
// ~1.1: class memeber만 가능
// 1.2~: top-level, class member, local variable 사용 가능
lateinit var data4: String

class MyClass {
    // init에서 초기화 한다면
    val data1: Int
    var data2: String

    init {
        data1 = 1
        data2 = "Shawn"
    }
    lateinit var data3: String
    fun some() {
        data3 = "hello"
        lateinit var data4: String
        println("$data4")
        data3 = data4
    }

    val data5: Int by lazy {
        println("lazy....")
        5
    }
}

