def solution(scores):
    scores = list(map(list, zip(*scores)))
    answer = '' 
    idx = 0
    for i in scores:
        selfScore = i[idx]
        if i.count(selfScore) == 1 and (selfScore == max(i) or selfScore == min(i)):
            i.pop(idx)
        avgScore = sum(i) / len(i)
        if avgScore >= 90: answer += 'A'
        elif avgScore >= 80: answer += 'B'
        elif avgScore >= 70: answer += 'C'
        elif avgScore >= 50: answer += 'D'
        else: answer += 'F'
        idx += 1
    
    return answer
