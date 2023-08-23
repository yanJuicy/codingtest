from itertools import combinations 

def setPrime():
    l = [False] * 50001
    l[1] = True
    for i in range(2, 50001):
        if l[i] == True: continue
        for j in range(i + i, 50001, i):
            l[j] = True
    return l

def solution(nums):
    answer = 0
    primes = setPrime()
    for i in list(combinations(nums, 3)):
        if primes[sum(i)] == False:
            answer += 1
    return answer