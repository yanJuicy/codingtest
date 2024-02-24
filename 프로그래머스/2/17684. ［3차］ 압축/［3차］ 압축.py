def solution(msg):
    answer = []
    
    word_dic = {}
    for alphabet in range(ord('A'), ord('Z') + 1):
        word_dic[chr(alphabet)] = len(word_dic) + 1
    
    start_idx, end_idx = 0, 0
    while end_idx != len(msg):
        if msg[start_idx : end_idx + 1] not in word_dic:
            answer.append(word_dic[msg[start_idx : end_idx]])
            word_dic[msg[start_idx : end_idx + 1]] = len(word_dic) + 1
            start_idx = end_idx
        
        end_idx += 1
        
    answer.append(word_dic[msg[start_idx : end_idx]])

    return answer