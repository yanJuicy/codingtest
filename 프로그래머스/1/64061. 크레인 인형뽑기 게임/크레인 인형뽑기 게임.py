def solution(board, moves):
    answer = 0
    n = len(board)
    
    stacks = [[] for i in range(n)]

    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                stacks[j].insert(0, board[i][j])
    
    basket = []
    
    for move in moves:
        move -= 1
        if stacks[move]:
            doll = stacks[move].pop()
            
            if basket and basket[-1] == doll:
                basket.pop()
                answer += 2
            else:
                basket.append(doll)
            
    
    return answer