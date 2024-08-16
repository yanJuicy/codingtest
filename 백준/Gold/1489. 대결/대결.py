result = 0
csort_a = [0] * 1002
csort_b = [0] * 1002

n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

for num in a:
    csort_a[num] += 1
for num in b:
    csort_b[num] += 1

for i in range(1, 1001):
    while csort_a[i]:
        is_a_win = False
        for j in range(i - 1, 0, -1):
            if csort_b[j]:
                result += 2
                csort_a[i] -= 1
                csort_b[j] -= 1
                is_a_win = True
                break

        if not is_a_win:
            break

for i in range(1, 1001):
    while csort_a[i] and csort_b[i]:
        result += 1
        csort_a[i] -= 1
        csort_b[i] -= 1


print(result)
