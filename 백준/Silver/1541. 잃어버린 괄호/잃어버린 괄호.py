answer = 0

equation = input().split('-')

for num in equation[0].split('+'):
    answer += int(num)

for sub_equation in equation[1:]:
    for num in sub_equation.split('+'):
        answer -= int(num)

print(answer)