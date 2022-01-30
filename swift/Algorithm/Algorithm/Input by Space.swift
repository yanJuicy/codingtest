//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let input = readLine()!
print(type(of: input))  // String

let result = input.split(separator: " ")
print(type(of: result)) // Array<Substring>

let result2 = input.split { $0 == " " }
print(type(of: result2))    // Array<Substring>

let result3 = input.components(separatedBy: " ")
print(type(of: result3))    // Array<String>


let input1 = readLine()!
let input2 = readLine()!
print(input1, input2)
