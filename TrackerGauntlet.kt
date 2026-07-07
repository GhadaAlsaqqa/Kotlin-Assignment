package org.example

fun main() {
    priorityDispatcher()
    separator()

    waypointsReverser()
    separator()

    maxWeightFilter()
    separator()

    palindromeChecker()
    separator()

    binarySearchLookup(intArrayOf(10, 30, 45, 77, 96, 101), 30)
}

fun separator() = println("#############")

fun priorityDispatcher() {
    println("Problem 1: Priority Dispatcher")
    for (packageIndex in 1..50) {
        println(
            when {
                packageIndex % 15 == 0 -> "PriorityExpress"
                packageIndex % 3 == 0 -> "Express"
                packageIndex % 5 == 0 -> "Freight"
                else -> packageIndex
            }
        )
    }
}

fun waypointsReverser() {
    println("Problem 2: Waypoints Reverser")

    val route = "HubA → HubB → HubC"

    var currentHub = ""
    var firstHub = ""
    var secondHub = ""
    var thirdHub = ""
    var hubNumber = 1

    for (routeIndex in 0 until route.length) {
        val currentChar = route[routeIndex]

        if (currentChar != '→' && currentChar != ' ') {
            currentHub += currentChar
        } else if (currentChar == '→') {
            if (hubNumber == 1) {
                firstHub = currentHub
            } else if (hubNumber == 2) {
                secondHub = currentHub
            }

            hubNumber++
            currentHub = ""
        }
    }

    thirdHub = currentHub
    println("$thirdHub -> $secondHub -> $firstHub")
}

fun maxWeightFilter() {
    println("Problem 3: Max Weight Filter ")
    val packageWeights = doubleArrayOf(12.3, -1.0, 8.2, 13.4, 16.2, 4.7)
    var maxValidWeight = 0.0
    for (currentWeight in packageWeights) {
        if (currentWeight != -1.0 && currentWeight > maxValidWeight) {
            maxValidWeight = currentWeight
        }

    }
    println("$maxValidWeight")
}

fun palindromeChecker() {
    println("Problem 4: Palindrome Checker ")
    val transitCode = "TR808RT".lowercase()
    var leftPointer = 0
    var rightPointer = transitCode.length - 1
    var isPalindrome = true
    while (leftPointer < rightPointer && isPalindrome) {
        if (transitCode[leftPointer] == transitCode[rightPointer]) {
            leftPointer++
            rightPointer--
        } else {
            isPalindrome = false

        }
    }
    if (isPalindrome) {
        println("Palindrome")
    } else {
        println("Not Palindrome")
    }
}

fun binarySearchLookup(trackingIds: IntArray, target: Int): Int {
    println("Problem 5: Binary Search Lookup")

    var left = 0
    var right = trackingIds.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        println("Checking: ${trackingIds[mid]}")

        if (trackingIds[mid] == target) {
            println("Found at index $mid")
            println("Time Complexity: O(log n)")
            return mid
        } else if (trackingIds[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    println("Not Found")
    println("Time Complexity: O(log n)")
    return -1
}
