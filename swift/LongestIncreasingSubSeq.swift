var sequences:[(tail:Int, size:Int)] = []
var smallest:Int!

func solve(array:[Int]) -> Int {
    
    for elem in array {
        if (sequences.isEmpty) {
            sequences.append((tail:elem, size:1))
        } else {
            // Case 1: elem is smallest so far. Start a new sequence
            let smallest = sequences.filter(<#includeElement: (T) -> Bool##(T) -> Bool#>)
            
            // Case 2: elem is larger than all the tails so far. Find largest sequence so far and extend it.
            
            // Case 3: elem is in neither the smallest, nor the largest.  Find the list whose tail is largest but still smaller than elem. Extend that list. Delete all other lists that have the same size.
        }
    }
    
    return 1
}

print(solve([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15])) // 6
