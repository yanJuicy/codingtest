directions = []
lengths = []
max_area = 1
min_area = 1

k = int(input())

for _ in range(6):
    d, l = map(int, input(). split())
    directions.append(d)
    lengths.append(l)


for d in [1, 2, 3, 4]:
    if directions.count(d) == 1:
        max_area_idx = directions.index(d)
        min_area_idx = max_area_idx + 3
        if min_area_idx >= 6:
            min_area_idx -= 6
        
        max_area *= lengths[max_area_idx]
        min_area *= lengths[min_area_idx]


print((max_area - min_area) * k)
