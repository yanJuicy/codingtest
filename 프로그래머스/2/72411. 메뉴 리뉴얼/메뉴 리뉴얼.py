from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for c in course:
        menu = []
        for order in orders:
            comb = combinations(sorted(order), c)
            menu.extend(comb)

        counter = Counter(menu)
        if counter and max(counter.values()) >= 2:
            for menu, order_count in counter.items():
                if order_count == max(counter.values()):
                    answer.append("".join(menu))
            
    return sorted(answer)