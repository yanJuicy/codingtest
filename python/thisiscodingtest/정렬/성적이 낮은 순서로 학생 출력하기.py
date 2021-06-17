n = int(input())
array = []

for i in range(n):
    name, grade = input().split()
    grade = int(grade)
    array.append((name, grade))

array = sorted(array, key=lambda student : (student[1], student[0]))

print(array)