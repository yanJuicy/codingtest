"""
1. a, b, c, d를 입력받는다.
2. mul(a, b, c, d) 함수를 만든다.
3. 출력한다.
"""


def mul(a, b):
    return a * b

# split() 안에 어떤 기호를 넣으면 그것을 기준으로 나눠준다.
a, b, c, d = map(int, input().split(','))
print(mul(mul(a, b), mul(c, d)))
