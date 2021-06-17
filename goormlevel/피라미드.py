n=int(input())
for i in range(1,n+1):
    for j in range(n,0,-1):
        print(" ", end="")
    n-=1
    for k in range(2*i-1):
        print('*', end="")
    print()