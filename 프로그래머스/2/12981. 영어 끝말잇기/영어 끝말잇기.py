def solution(n, words):
    answer = [0, 0]
    
    word_set = set()
    prev_word_last_alphabet = words[0][0]

    for index, word in enumerate(words):
        if word in word_set or word[0] != prev_word_last_alphabet:
            answer = [index % n + 1, index // n + 1]
            break
        word_set.add(word)
        prev_word_last_alphabet = word[-1]

    return answer