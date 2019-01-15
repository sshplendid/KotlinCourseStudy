package ch9

open class Shape {
    open fun getArea(): Int {
        println("shape cannot calculate area")
        return 0
    }
}

class Rect: Shape() {
    val height: Int = 0
    val width: Int = 0
    override fun getArea(): Int {
      return height * width
   }
}



