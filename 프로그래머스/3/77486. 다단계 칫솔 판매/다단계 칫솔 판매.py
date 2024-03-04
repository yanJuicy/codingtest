def solution(enroll, referral, seller, amount):
    answer = {name: 0 for name in enroll}
    
    parent_dic = dict(zip(enroll, referral))
    
    for i in range(len(seller)):
        income = amount[i] * 100
        receiver = seller[i]
        
        while income > 0 and receiver != '-':
            answer[receiver] += income - income // 10
            income //= 10
            receiver = parent_dic[receiver]
        
    return list(answer.values())