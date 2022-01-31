//
//  11652.swift
//  Algorithm
//
//  Created by 이한주 on 2022/01/30.
//

import Foundation

let N: Int = Int(readLine()!)!
var a: [Int64] = []

for _ in 0..<N {
    a.append(Int64(readLine()!)!)
}

a.sort()

var mode: Int64 = a[0]
var modeCount = 1
var curCount = 1

for i in 1..<N {
    if a[i] == a[i-1] {
        curCount += 1
    } else {
        curCount = 1
    }
    if curCount > modeCount {
        mode = a[i]
        modeCount = curCount
    }
}

print(mode)
