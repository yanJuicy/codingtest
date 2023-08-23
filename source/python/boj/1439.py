import sys
input = sys.stdin.readline

s = input()

cnt = [0, 0]
cnt[ord(s[0]) - ord('0')] += 1
for i in range(0, len(s.strip()) - 1):
    if s[i] != s[i + 1]:
        cnt[ord(s[i + 1]) - ord('0')] += 1

print(min(cnt))