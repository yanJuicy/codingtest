n = int(input())
for _ in range(n):
    s = input()
    s = s.lower()
    r = s[::-1]
    if s == r: 
        print("Yes")
    else:
        print("No")