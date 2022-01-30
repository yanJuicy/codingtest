//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let n: Int = Int(readLine()!)!
var result: String = ""

for i in 1...n {
    if n % i == 0 {
        result += "\(i) "
    }
}

print(result)
