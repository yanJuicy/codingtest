//
//  main.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/17.
//

import Foundation

let input = readLine()
print(type(of: input))  // Optional<String>

let inputOut = input!
print(type(of: inputOut))   // String

let intVar = Int(inputOut)
print(type(of: intVar)) // Optional<Int>

let result = intVar!
print(type(of: result)) // Int

// 정수 입력 받기
let inputInt = Int(readLine()!)!


