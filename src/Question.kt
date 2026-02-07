class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>(
        questionText = "Речка спятила с ума - По домам пошла сама. ___",
        answer = "водопровод",
        difficulty = "medium"
    )
        val question2 = Question<Boolean>(
        questionText = "Небо зелёное. Правда или ложь",
        answer = false,
        difficulty = "easy"
        )
        val question3 = Question<Int>(
        questionText = "Сколько дней между полнолуниями?",
        answer = 28,
        difficulty = "hard"
    )
                println(question1.answer)
                println(question2.answer)
                println(question3.answer)
}