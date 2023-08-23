n, k = input().split()
a = input().split()

count = 0

for num_str in a:
    if k not in num_str:
        count += 1

print(count)
