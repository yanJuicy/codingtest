from collections import deque

def solution(progresses, speeds):
    q = deque()
    
    for i in range(len(progresses)):
        remain = (100 - progresses[i]) // speeds[i]
        if (100 - progresses[i]) % speeds[i] != 0:
            remain += 1
        q.append(remain)
        
    answer = []
    
    while q:
        count = 0
        remain = q[0]
        while q and remain >= q[0]:
            q.popleft()
            count += 1
        answer.append(count)
    
    return answer