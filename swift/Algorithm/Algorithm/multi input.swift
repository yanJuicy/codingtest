//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let input1 = readLine()!.split(separator: " ").map {
    Int(String($0))!
}
print(type(of: input1))


let input = Array(readLine()!)
print(input)
print(type(of: input))

let result = input.map { Int(String($0))! }
print(result)
print(type(of: result))
