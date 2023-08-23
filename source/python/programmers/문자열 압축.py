def solution(s):
    answer = len(s)
    result = ""
    for length in range(1, len(s) // 2 + 1):
        unit = s[:length]
        cnt = 1
        for i in range(length, len(s), length):
            if s[i:i+length] == unit:
                cnt += 1
            else:
                if cnt == 1:
                    cnt = ""
                result += str(cnt) + unit
                unit = s[i:i+length]
                cnt = 1
        if cnt == 1:
            cnt = ""
        result += str(cnt) + unit
        if answer > len(result):
            answer = len(result)
        result = ""

    return answer