def solution(n, lost, reserve):
    answer = n
    
    temp = [i for i in lost]
    for i in temp:
        if reserve.count(i):
            reserve.remove(i)
            lost.remove(i)

    for i in lost:
        if reserve.count(i - 1):
            reserve.remove(i - 1)
        elif reserve.count(i + 1):
            reserve.remove(i + 1)
        else:
            answer -= 1
    return answer