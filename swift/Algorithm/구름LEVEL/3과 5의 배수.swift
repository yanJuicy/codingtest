//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let N: Int = Int(readLine()!)!

var sum: Int = 0

for i in 1...N {
    if i % 15 == 0 {
        sum += i
    } else if i % 3 == 0 {
        sum += i
    } else if i % 5 == 0 {
        sum += i
    }
}

print(sum)
