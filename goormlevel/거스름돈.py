price=int(input())
N=1000-price
a,b,c,d=0,0,0,0
a=N//500
N=N-500*a
b=N//100
N=N-b*100
c=N//50
N=N-c*50
d=N//10
N=N-d*10
print(a,b,c,d, end = ' ')