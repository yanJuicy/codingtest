def solution(want, number, discount):
    answer = 0
    
    want_dic = {}
    for i in range(len(want)):
        want_dic[want[i]] = number[i]
    
    discount_dic = {}
    for i in range(len(discount)):
        if discount[i] in discount_dic:
            discount_dic[discount[i]] += 1
        else:
            discount_dic[discount[i]] = 1
            
        if i >= 9:
            if want_dic == discount_dic:
                answer += 1
            discount_dic[discount[i - 9]] -= 1
            if discount_dic[discount[i - 9]] == 0:
                del discount_dic[discount[i - 9]]
            
            
    return answer