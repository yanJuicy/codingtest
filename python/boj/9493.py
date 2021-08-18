while True:
    m, a, b = map(int, input().split())
    if m == 0 and a == 0 and b == 0:
        break
    
    speedA = m / a * 3600
    speedB = m / b * 3600
    diff = round(abs(speedA - speedB))
    print("%d:%02d:%02d" % (diff / 3600, diff % 3600 / 60, diff % 3600 % 60))