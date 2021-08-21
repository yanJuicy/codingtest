def solution(numbers, hand):
    answer = ''
    left, right = '*', '#'
    for i in numbers:
        if i in [1, 4, 7]:
            answer += 'L'
            left = i
        elif i in [3, 6, 9]:
            answer += 'R'
            right = i
        else:
            pad = {1: [0, 0], 2: [0, 1], 3: [0, 2],
                    4: [1, 0], 5: [1, 1], 6: [1, 2],
                    7: [2, 0], 8: [2, 1], 9: [2, 2],
                    '*': [3, 0], 0: [3, 1], '#':[3, 2]}
            ld = abs(pad.get(i)[0] - pad.get(left)[0]) + abs(pad.get(i)[1] - pad.get(left)[1])
            rd = abs(pad.get(i)[0] - pad.get(right)[0]) + abs(pad.get(i)[1] - pad.get(right)[1])
            if ld < rd:
                left = i
                answer += 'L'
            elif ld > rd:
                right = i
                answer += 'R'
            else:
                answer += hand[0].upper()
                if hand == 'left':
                    left = i
                else:
                    right = i

    return answer

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))