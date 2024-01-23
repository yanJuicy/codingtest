def solution(n, k, cmd):
    up = [i for i in range(-1, n + 1)]
    down = [i for i in range(1, n + 2)]
    
    k += 1
    del_stack = []
    
    for udcz in cmd:
        if 'U' in udcz:
            step = int(udcz[2:])
            for _ in range(step):
                k = up[k]

        if 'D' in udcz:
            step = int(udcz[2:])
            for _ in range(step):
                k = down[k]
        
        if 'C' == udcz:
            del_stack.append(k)
            up[down[k]] = up[k]
            down[up[k]] = down[k]
            k = down[k] if down[k] <= n else up[k]
        
        if 'Z' == udcz:
            restore = del_stack.pop()
            down[up[restore]] = restore
            up[down[restore]] = restore
    
    answer = ['O'] * n
    for delete_row in del_stack:
        answer[delete_row - 1] = 'X'
    return "".join(answer)