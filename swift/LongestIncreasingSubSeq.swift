import Foundation

public func getLine() -> String {
    var buf = String()
    var c = getchar()
    // 10 is ascii code for newline
    while c != EOF && c != 10 {
        buf.append(UnicodeScalar(UInt32(c)))
        c = getchar()
    }
    return buf
}

func solve(array:[Int]) -> Int {
    var sequences:[(tail:Int, size:Int)] = []
    
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

var array:[Int] = []
let n = Int(getLine())
for i in 1...n! {
    array.append(Int(getLine())!)
}

print(solve(array))
