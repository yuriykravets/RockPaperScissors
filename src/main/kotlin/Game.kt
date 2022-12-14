import java.util.*

fun main(args: Array<String>) {
    val arrayElements = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(arrayElements)
    val userChoice = getUserChoice(arrayElements)
    val printResult = printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following: ")
        for (item in optionsParam) print(" $item")
        println(".")
        val userInput = readLine()
        userInput?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        if (userInput != null && userInput in optionsParam){
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter valid choice")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    //Result received
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) result = "You win!"
    else result = "You lose!"
    //Вывести результат
    println("You chose $userChoice. I chose $gameChoice. $result")
}

