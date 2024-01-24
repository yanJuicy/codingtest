def solution(arr):
    answer = []
    
    for n in arr:
        if not (answer and n == answer[-1]):
            answer.append(n)
    
    return answer