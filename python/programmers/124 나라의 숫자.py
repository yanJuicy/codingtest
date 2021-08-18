def solution(n):
    remains = ['4', '1', '2']
    answer = ''
    
    while n > 0:
        idx = n % 3
        answer = remains[idx] + answer
        n //= 3 
        if idx == 0: n -= 1


    return answer

print(solution(4))