def backtracking(index, sum):
    global minAns
    global maxAns

    if index == n - 1:
        if minAns > sum:
            minAns = sum
        if maxAns < sum:
            maxAns = sum
        return

    for i in range(4):
        temp = sum
        if operator[i] == 0:
            continue
        if i == 0:
            sum += numArr[index + 1]
        elif i == 1:
            sum -= numArr[index + 1]
        elif i == 2:
            sum *= numArr[index + 1]
        else:
            if sum < 0: 
                sum = abs(sum) // numArr[index + 1] * - 1
            else:
                sum //= numArr[index + 1]
        
        operator[i] -= 1
        backtracking(index + 1, sum)
        operator[i] += 1
        sum = temp


n = int(input())
numArr = list(map(int, input().split()))
operator = list(map(int, input().split()))
minAns = 1000000001
maxAns = -1000000001

backtracking(0, numArr[0])
print(maxAns)
print(minAns)