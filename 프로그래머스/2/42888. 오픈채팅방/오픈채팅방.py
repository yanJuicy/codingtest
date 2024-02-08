def solution(record):
    
    uid_nickname_dic = {}
    chats = []
    
    for r in record:
        cmd = r.split()[0]
        uid = r.split()[1]
        
        if cmd == "Enter" or cmd == "Change":
            nickname = r.split()[2]
            uid_nickname_dic[uid] = nickname
        
        if cmd == "Enter":
            chats.append(f"{uid} Enter")
        if cmd == "Leave":
            chats.append(f"{uid} Leave")
    
    answer = []
    for chat in chats:
        uid, cmd = chat.split()
        if cmd == "Enter":
            answer.append(f"{uid_nickname_dic[uid]}님이 들어왔습니다.")
        else:
            answer.append(f"{uid_nickname_dic[uid]}님이 나갔습니다.")
            
    return answer