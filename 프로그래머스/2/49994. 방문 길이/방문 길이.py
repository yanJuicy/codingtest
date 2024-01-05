def solution(dirs):
    
    traces = []
    current = [0, 0]
    
    for dir in dirs:
        if dir == "U": 
            next = [current[0] + 1, current[1]]
        elif dir == "D": 
            next = [current[0] - 1, current[1]]
        elif dir == "R": 
            next = [current[0], current[1] + 1]
        else: 
            next = [current[0], current[1] - 1]
            
        if next[0] > 5 or next[0] < -5 or next[1] > 5 or next[1] < -5:
            continue
            
        if current + next not in traces and next + current not in traces:
            traces.append(current + next)
        current = next
            
    answer = len(traces)
    return answer