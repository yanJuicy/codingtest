N=int(input())
li=[]
li =  list(map(str,input().split()))

# li = (['r', 'r', 'r', 'u', 'd'])

a=1
b=1
for i in range (0, len(li)):
    if li[i]=='L' and b!=1:
        b+=1
    elif li[i]=='R' and b!=N:
        b+=1
    elif li[i]=='U' and a!=1:
        a-=1
    elif li[i]=='D' and a!=N:
        a+=1
print (a,b)

# li = [int, string, list,]
# steps = [string, string, string]
# li = [list]