def solution(numbers, hand):
    answer = ''
    left, right = 0, 0
    for i in numbers:
        if i in [1, 4, 7]:
            answer += 'L'
            left = i
        elif i in [3, 6, 9]:
            answer += 'R'
            right = i
        else:
            pass

    return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))