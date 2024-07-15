brackets = input()

stack = []
sum = 0

for i in range(len(brackets)):
    if brackets[i] == '(':
        stack.append(brackets[i])
    else:
        if brackets[i - 1] == '(':
            sum += len(stack) - 1
        else:
            sum += 1

        stack.pop(-1)

print(sum)