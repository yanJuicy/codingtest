def hanoi(n, src, aux, dest):
    if n == 1:
        print(src, dest)
    else:
        hanoi(n - 1, src, dest, aux)
        print(src, dest)
        hanoi(n - 1, aux, src, dest)


n = int(input())

print(2**n - 1)
hanoi(n, 1, 2, 3)
