def solution(lottos, win_nums):
    minValue = 0
    for i in lottos:
        if i in win_nums:
            minValue += 1
    maxValue = minValue + lottos.count(0)
    score = [6, 6, 5, 4, 3, 2, 1]
    answer = []
    answer.append(score[maxValue])
    answer.append(score[minValue])
    return answer

print(solution([0, 0, 0, 0, 0, 0], [31, 10, 45, 1, 6, 19]))