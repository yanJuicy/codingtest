def binary_search(array, target, start, end):
    if start > end:
        return False
    mid = (start + end) // 2
    if array[mid] == target:
        return True
    elif array[mid] < target:
        return binary_search(array, target, mid + 1, end)
    else:
        return binary_search(array, target, start, mid - 1)

n = int(input())
l = list(map(int, input().split()))
m = int(input())
x = list(map(int, input().split()))

l.sort()
for i in x:
    print("yes" if binary_search(l, i, 0, n-1) == True else "no", end=' ')

for i in x:
    if i in l:
        print('yes', end=' ')
    else:
        print('no', end=' ')