# 입력
"""
1. 숫자 n을 입력 받는다
2. 0부터 n까지 리스트를 만든다.
3. for 문으로 하나씩 꺼내서 i에 집어 넣는다
4. n % i == 0 이면 리스트 result로 저장한다.
5. for 문이 끝난 후 리스트 result를 출력한다.
"""

n = int(input()) # input()으로 받으면 문자열이다.

# range(end) : 0 부터 end-1까지
# range(start, end): start 부터 end - 1 까지

for i in range(1, n+1):
    if n % i == 0:
        print(i, end=' ')


