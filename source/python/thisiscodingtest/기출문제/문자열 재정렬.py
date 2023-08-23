s = input()

alphabets = []
num = 0

for x in s:
    if x.isalpha():
        alphabets.append(x)
    else:
        num += int(x)

alphabets.sort()

if num != 0:
    alphabets.append(str(num))

print(alphabets)
print(''.join(alphabets))