import sys
import heapq

heap = []
sum = 0

n = int(sys.stdin.readline())

for _ in range(n):
    card_size = int(sys.stdin.readline())
    heapq.heappush(heap, card_size)

while len(heap) > 1:
    a = heapq.heappop(heap)
    b = heapq.heappop(heap)
    sum += a + b
    heapq.heappush(heap, a + b)

print(sum)