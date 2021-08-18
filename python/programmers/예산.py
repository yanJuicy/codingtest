def solution(d,budget):
    answer=0
    sum=0
    d.sort()
    for i in range(len(d)):
        if sum>budget:
            answer=i-1
        elif sum==budget:
            answer=i+1
        else:
            sum+=int(d[i])
    return answer

print(solution([2, 2, 3, 3], 10))