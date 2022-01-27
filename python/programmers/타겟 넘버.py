def solution(numbers, target):
    answer = 0
    st = []
    st.append([0, numbers[0]])
    st.append([0, -1 * numbers[0]])

    while st:
        idx, value = st.pop()
        if idx + 1 == len(numbers):
            if value == target:
                answer += 1
        else:
            st.append([idx + 1, value + numbers[idx + 1]])
            st.append([idx + 1, value - numbers[idx + 1]])

    return answer

print(solution([1, 1, 1, 1, 1], 3))