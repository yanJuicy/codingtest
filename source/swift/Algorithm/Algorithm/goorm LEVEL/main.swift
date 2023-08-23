import Foundation

let input = readLine()!.split(separator: " ").map{Int($0)!}

let kor = input[0]
let eng = input[1]
let math = input[2]

let avg: Double = Double(kor + eng + math) / 3

var res = String(format: "%.2f", avg)

if avg > 90 {
    res = "\(res) A"
} else if avg > 80 {
    res = "\(res) B"
}else if avg > 70 {
    res = "\(res) C"
}else if avg > 60 {
    res = "\(res) D"
} else {
    res = "\(res) F"
}

print(res)
