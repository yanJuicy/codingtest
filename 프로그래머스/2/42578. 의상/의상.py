from collections import defaultdict

def solution(clothes):
    d = defaultdict(int)
    for _, category in clothes:
        d[category] += 1
    
    answer = 1
    for cnt in d.values():
        answer *= (cnt + 1)
    return answer - 1