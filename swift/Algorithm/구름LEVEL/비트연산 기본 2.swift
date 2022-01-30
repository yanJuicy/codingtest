//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let input = (readLine()!).components(separatedBy: " ")

let a = Int(input[0])!
let b = Int(input[1])!

let result1: Int = a >> b
let result2: Int = a << b

print(result1)
print(result2)
