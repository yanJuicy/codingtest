s = input()

zero = 0
one = 0

state = s[0]
if state == '0': zero += 1
else: one += 1

for i in s:
    if i != state:
        state = i
        if state == '0': zero += 1
        else: one += 1

print(zero if zero < one else one)