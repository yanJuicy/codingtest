n = int(input())
arr = list(map(int, input().split()))
s = int(input())

while True:
    sort_done = True

    for i in range(n):
        idx = i
        change_step = 0

        for j in range(n - 1, i, -1): # i의 오른쪽에서 최대값 찾기
            if arr[idx] < arr[j] and j - i <= s:
                idx = j
                sort_done = False
                change_step = j - i
        
        if idx != i: # 최대값 발견 후 정렬
            temp = arr[idx]
            del arr[idx]
            arr.insert(i, temp) 
            s -= change_step

    if sort_done:
        break

print(*arr)