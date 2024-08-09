meet = []
answer = 0
endTime = 0

n = int(input())

for _ in range(n):
    begin, end = map(int, input().split())
    meet.append([begin, end])

meet.sort(key= lambda x: (x[1], x[0]))

for meet_begin, meet_end in meet:
    if endTime <= meet_begin:
        endTime = meet_end
        answer += 1

print(answer)
