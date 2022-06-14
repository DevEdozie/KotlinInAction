import java.io.Serializable

//interface State : Serializable

/*

interface View{
    fun getCurrenState() : State
    fun restoreState(state: State){}
}

class Button : View {
    override fun getCurrenState(): State = ButtonState()

     override fun restoreState(state: State) {

    }

    //similar to a static nested class in Java
    class ButtonState : State{
        //nested class
    }
}

class Outer{
    inner class Inner{
        fun getOuterReference() : Outer = this@Outer
    }
}


sealed class Expr{
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr,val right : Expr): Expr()
}

fun eval(e: Expr) : Int =
        when(e){
           is Expr.Num ->  e.value
           is Expr.Sum -> eval(e.right) + eval(e.left)
        }
        */