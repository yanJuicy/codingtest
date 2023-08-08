import re
from collections import defaultdict

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split() if word not in banned]
        
        counts = defaultdict(int)
        for word in words:
            counts[word] += 1
        
        return max(counts, key=counts.get)
        
