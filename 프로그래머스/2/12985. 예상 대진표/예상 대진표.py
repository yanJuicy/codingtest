import math

def solution(n,a,b):
    answer = 1

    while not (a % 2 == 0 and a - 1 == b) and not (a % 2 == 1 and a + 1 == b):
        a = math.ceil(a / 2)
        b = math.ceil(b / 2)
        answer += 1

    return answer