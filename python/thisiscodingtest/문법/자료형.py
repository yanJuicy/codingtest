a = 1000
print(a)

a = -7
print(a)

a = 0
print(a)

a = 157.93
print(a)

a = -1837.2
print(a)

a = 5.
print(a)

a = -.7
print(a)

a = 1e9
print(a)

a = 75.25e1
print(a)

a = 3954e-3
print(a)

a = 0.3 + 0.6
print(round(a, 4))

a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a)

a = list()
print(a)

n = 10
a = [0] * n
print(a)

a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a[1: 4])

array = [i for i in range(20) if i % 2 == 1]
print(array)

array = [i * i for i in range(1, 10)]
print(array)

n = 3
m = 4
array = [[0] * m for _ in range(n)]
print(array)

a = [1, 4, 3]
a.append(2)
a.sort()
a.sort(reverse=True)
a.reverse()
a.insert(2, 3)
a.count(3)
a.remove(1)

a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3, 5}
result = [i for i in a if i not in remove_set]
print(result)

a = (1, 2, 3, 4)
print(a)

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
print(data)

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'

key_list = data.keys()
value_list = data.values()
print(key_list)
print(value_list)

for key in key_list:
    print(data[key])

data = set([1, 1, 2, 3, 4, 4, 5])
print(data)

data = {1, 1, 2, 3, 4, 4, 5}
print(data)

a = set([1, 2, 3, 4, 5])
b = set([3, 4, 5, 6, 7])

print(a | b)
print(a & b)
print(a - b)

data = set([1, 2, 3])
print(data)

data.add(4)
data.update([5, 6])
data.remove(3)
print(data)
