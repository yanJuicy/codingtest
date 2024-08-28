answer = [0] * 10
rest_add_nums = 0
rest_add_num_zero = 1
digit = 1

n = int(input())

while n > 0:
    cur = n % 10
    n //= 10

    answer[0] -= digit
    for i in range(cur):
        answer[i] += (n + 1) * digit
    answer[cur] += n * digit + rest_add_nums + rest_add_num_zero
    for i in range(cur + 1, 9 + 1):
        answer[i] += n * digit

    rest_add_nums += cur * digit
    digit *= 10


print(*answer)
