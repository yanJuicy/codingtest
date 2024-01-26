def solution(s):
    stack = []
    
    for n in s.split(" "):
        if "Z" == n:
            stack.pop()
        else:
            stack.append(int(n))
    answer = sum(stack)
    return answer