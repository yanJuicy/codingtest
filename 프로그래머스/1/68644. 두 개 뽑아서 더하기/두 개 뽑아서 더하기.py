def solution(numbers):
    answer = []
    
    for a in range(len(numbers)):
        for b in range(a + 1, len(numbers)):
            answer.append(numbers[a] + numbers[b])
    
    answer = sorted(set(answer)) 
    
    return answer