var sequences:[(tail:Int, size:Int)] = []

func solve(array:[Int]) -> Int {
    
    for elem in array {
        if (sequences.isEmpty) {
            sequences.append((tail:elem, size:1))
        } else {
            // Case 1: elem is smallest so far. Start a new sequence
            let smallest = sequences[0]
            if (elem < smallest.tail) {
                sequences[0] = (tail:elem, size:1)
            } else {
                // Case 2: elem is larger than all the tails so far. 
                // Find longest sequence so far and extend it.
                let largestTail = sequences.maxElement({$0.tail < $1.tail})
                if (elem > largestTail?.tail) {
                    let longest = sequences.maxElement({$0.size < $1.size})
                    let extendedSeq = (tail:elem, size:longest!.size+1)
                    sequences.append(extendedSeq)
                } else {
                    // Case 3: elem is in neither the smallest, nor the largest.  
                    // Find the list whose tail is largest but still smaller than elem. 
                    // Extend that list. Delete all other lists that have the same size.
                    let minMax = (sequences.filter() {$0.tail < elem}).maxElement({$0.tail < $1.tail})
                    let extendedSeq = (tail:elem, size:minMax!.size+1)
                    sequences = sequences.filter() {$0.size != extendedSeq.size} 
                    sequences.append(extendedSeq)
                    
                }
            }
        }
    }
    
    
    return  sequences.maxElement({$0.size < $1.size})!.size
}

print(solve([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15])) // 6
// 0, 2, 6, 9, 11, 15
