def solution(N, stages):
    fail = {}
    
    challengers = len(stages)
    for stage in range(1, N + 1):
        if challengers == 0: 
            fail[stage] = 0
            continue
        failers = stages.count(stage)
        fail[stage] = failers / challengers
        challengers -= failers
        
    answer = sorted(fail, key=lambda x: fail[x], reverse=True)
    print(answer)
    
    return answer