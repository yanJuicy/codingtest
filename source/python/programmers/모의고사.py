def solution(answers):
    l1 = [1, 2, 3, 4, 5] * 2000
    l2 = [2, 1, 2, 3, 2, 4, 2, 5] * 1250
    l3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 1000
    
    p1, p2, p3 = [0, 0, 0]
    for i in range(len(answers)):
        if l1[i] == answers[i]: 
            p1 += 1
        if l2[i] == answers[i]: 
            p2 += 1
        if l3[i] == answers[i]: 
            p3 += 1
    score = [p1, p2, p3]

    answer = []
    for i, s in enumerate(score):
        if s == max(score):
            answer.append(i + 1)
    return answer

print(solution([1, 3, 2, 4, 2]))