package org.example

fun main() {
    priorityDispatcher()
    println("#############")

    waypointsReverser()
    println("#############")

    maxWeightFilter()
    println("#############")

    palindromeChecker()
    println("#############")

    binarySearchLookup()
}

fun priorityDispatcher() {
    println("Problem 1: Priority Dispatcher")
    for (packageIndex in 1..50) {
        val isMultipleOf3 = packageIndex % 3 == 0
        val isMultipleOf5 = packageIndex % 5 == 0
        val isPriorityPackage = isMultipleOf3 && isMultipleOf5
        if (isPriorityPackage) {
            println("PriorityExpress")
        } else if (isMultipleOf3) {
            println("Express")
        } else if (isMultipleOf5) {
            println("Freight")
        } else {
            println(packageIndex)
        }
    }
}

fun waypointsReverser() {
    println("Problem 2: Waypoints Reverser")

    val route = "HubA → HubB → HubC"
    var currentHub = ""
    var hub1 = ""
    var hub2 = ""
    var hub3 = ""
    var hubCounter = 1
    for (i in 0..route.length - 1) {

        if (route[i] != '→' && route[i] != ' ') {
            currentHub += route[i]
        } else if (route[i] == '→') {

            if (hubCounter == 1) {
                hub1 = currentHub
            } else if (hubCounter == 2) {
                hub2 = currentHub
            }
            hubCounter++
            currentHub = ""
        }
    }
    hub3 = currentHub
    println("$hub3 -> $hub2 -> $hub1")
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

fun binarySearchLookup() {
    println("Problem 5: Binary Search Lookup ")
    val trackingIds = intArrayOf(101, 205, 309, 320, 412, 518, 620)
    val targetTrackingId = 412

    var left = 0
    var right = trackingIds.size - 1
    var isFound = false

    while (left <= right) {

        val mid = (left + right) / 2

        println("Checking: ${trackingIds[mid]}")

        if (trackingIds[mid] == targetTrackingId) {
            println("Found")
            isFound = true
            break
        } else if (trackingIds[mid] > targetTrackingId) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    if (!isFound) {
        println("Not Found")
    }

}