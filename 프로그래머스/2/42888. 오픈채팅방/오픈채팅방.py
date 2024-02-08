def solution(record):
    uid_nickname_dic = {}

    for r in record:
        chat = r.split()

        if chat[0] == "Enter" or chat[0] == "Change":
            uid_nickname_dic[chat[1]] = chat[2]
        
    
    answer = []
    for r in record:
        chat = r.split()
        if chat[0] == "Enter":
            answer.append(f"{uid_nickname_dic[chat[1]]}님이 들어왔습니다.")
        if chat[0] == "Leave":
            answer.append(f"{uid_nickname_dic[chat[1]]}님이 나갔습니다.")
            
    return answer