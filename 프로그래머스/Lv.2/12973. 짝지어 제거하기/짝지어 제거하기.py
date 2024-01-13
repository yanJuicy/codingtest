def solution(s):
    answer = 0
    
    stack = []
    for c in s:
        if not stack:
            stack.append(c)
            continue
        
        if stack[-1] == c:
            stack.pop()
        else:
            stack.append(c)
    
    if not stack:
        answer = 1

    return answer