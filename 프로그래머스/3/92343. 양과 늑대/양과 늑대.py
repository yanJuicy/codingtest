def solution(info, edges):
    answer = 0

    tree = [[] for _ in range(len(info))]
    for edge in edges:
        tree[edge[0]].append(edge[1])

    q = [(0, 1, 0, set())]  # 현재 위치, 양의 수, 늑대의 수, 방문한 노드 집합

    while q:
        current_node, sheep_count, wolf_count, visited = q.pop(0)
        answer = max(answer, sheep_count)
        visited.update(tree[current_node])

        for next_node in visited:
            if info[next_node]:
                if sheep_count > wolf_count + 1:
                    q.append((next_node, sheep_count, wolf_count + 1, visited - {next_node}))
            else:
                q.append((next_node, sheep_count + 1, wolf_count, visited - {next_node}))

    return answer