

def getMaximumHeight(height, month, n, m):
    maxHeight = -1

    for i in range(n-1, 0-1, -1):
        if m is month[i]:
            maxHeight = height[i]
            break

    return maxHeight


if __name__ == "__main__":
    n = int(input())
    height = list(map(int, input().split()))
    month = list(map(int, input().split()))
    m = int(input())
    
    answer = getMaximumHeight(height, month, n, m)
    print(answer)
