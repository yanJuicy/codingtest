def solution(babbling):
    answer = 0
    pronounces = ["aya", "ye", "woo", "ma"]
    
    for babb in babbling:
        length = len(babb)
        for pronounce in pronounces:
            if pronounce in babb:
                length -= len(pronounce)
        if length == 0:
            answer += 1

    return answer