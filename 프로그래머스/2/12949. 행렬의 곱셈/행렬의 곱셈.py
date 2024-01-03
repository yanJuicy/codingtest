def solution(arr1, arr2):
    answer = []
    
    mul_row = len(arr1)
    mul_col = len(arr2[0])
    mul_len = len(arr1[0])
    
    for i in range(mul_row):
        temp = []
        for j in range(mul_col):
            sum = 0
            for k in range(mul_len):
                sum += arr1[i][k] * arr2[k][j]
            temp.append(sum)
        answer.append(temp)
            
    return answer