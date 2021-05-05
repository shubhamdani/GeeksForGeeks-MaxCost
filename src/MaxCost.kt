import java.util.*

class MaxCost(val s: String, val p: Int, val q: Int) {

    var repeatP = "ab".toCharArray()
    var repeatQ = "ba".toCharArray()
    var cost = 0

    fun calculateCost(): Int {

        if (p > q) {
            val remainingString = findCost(s.toCharArray(), p, repeatP)
            findCost(remainingString, q, repeatQ)
        } else {
            val remainingString = findCost(s.toCharArray(), q, repeatQ)
            findCost(remainingString, p, repeatP)
        }
        return cost
    }

    private fun findCost(s: CharArray, p: Int, repeatAble: CharArray, stack: Stack<Char> = Stack()): CharArray {
        s.forEach { char ->
            if (stack.isNotEmpty() && (repeatAble[0] == stack.peek() && repeatAble[1] == char)) {
                cost += p
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        return stack.toCharArray()
    }
}