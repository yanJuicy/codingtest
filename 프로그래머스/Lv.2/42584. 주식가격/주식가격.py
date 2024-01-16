def solution(prices):
    length = len(prices)
    answer = [0] * length
    stack = []
    
    for i in range(0, length):
        while stack and prices[stack[-1]] > prices[i]:
            top = stack.pop()
            answer[top] = i - top
        stack.append(i)
    
    while stack:
        top = stack.pop()
        answer[top] = length - top - 1
    
    return answer