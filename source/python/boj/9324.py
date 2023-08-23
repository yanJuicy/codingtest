t = int(input())

for _ in range(t):
    s = input()
    alphabets = [0] * 26
    result = True
    for i in range(len(s)):
        idx = ord(s[i]) - ord('A')
        alphabets[idx] += 1
        if alphabets[idx] == 3:
            if i + 1 < len(s) and s[i + 1] == s[i]: 
                alphabets[idx] = -1
            else:
                result = False
                break
    if result:
        print("OK")
    else:
        print("FAKE")