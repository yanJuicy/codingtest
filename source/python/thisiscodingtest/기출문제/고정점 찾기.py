n = int(input())
l = list(map(int, input().split()))

def binary_search(left, right):
    while left <= right:
        mid = (left + right) // 2
        if l[mid] == mid:
            return mid
        elif l[mid] < mid:
            left = mid + 1
        else:
            right = mid - 1
    return -1

print(binary_search(0, n-1))
        