from collections import deque
import math

def solution(progresses, speeds):
    q = deque([math.ceil((100 - progresses[i]) / speeds[i]) for i in range(len(progresses))])
        
    answer = []
    
    while q:
        count = 0
        remain = q[0]
        while q and remain >= q[0]:
            q.popleft()
            count += 1
        answer.append(count)
    
    return answer