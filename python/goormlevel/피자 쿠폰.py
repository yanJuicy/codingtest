n, m = map(int, input().split())

coupons = n

while coupons // m > 0:
    newPizza = coupons // m
    n += newPizza
    coupons = coupons % m + newPizza

print(n)

