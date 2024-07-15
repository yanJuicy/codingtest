brackets = input()

stack = []
sum = 0

for i in range(len(brackets)):
    if brackets[i] == '(':
        stack.append((brackets[i], i))
    else:
        last_idx = stack[-1][1]
        last_bracket = stack[-1][0]

        stack.pop(-1)

        if last_idx + 1 == i:
            sum += len(stack)
        else:
            sum += 1

print(sum)