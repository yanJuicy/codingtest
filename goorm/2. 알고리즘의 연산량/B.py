


def isOrdered(data, n):
    for i in range(n - 1):
        if data[i] > data[i+1]:
            return False
    return True

if __name__ == "__main__":
    n = int(input())
    data = list(map(int, input().split()))

    result = isOrdered(data, n)

    print("YES" if result == True else "NO")