d = [0] * 32001

def solve(N, number):
    if N == number: return 1

    result = solve(N + 5)  + 1
    reslut = min(result, solve(N - 5, number) + 1)
    result = min(result, solve(N * 5, number) + 1)
    result = min(result, solve(N / 5, number) + 1)
    result = min(result, solve(N + 1, number) + 2)
    result = min(result, solve(N - 1, number) + 2)

    d[N] = result
    return result

def solution(N, number):
    answer = 0
    
    d[0] = 1
     
    
    return answer