import sys
from collections import deque

def find_unique_rotations(words):
    unique_rotations = set()

    for word in words:
        dq = deque(word)
        while True:
            dq.append(dq.popleft())
            rotated_word = "".join(dq)
            if rotated_word == word:
                break

            if rotated_word in words:
                idx = words.index(rotated_word)
                words.pop(idx)
                words.insert(idx, word)

    unique_rotations = set(words)
    return len(unique_rotations)

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    words_list = [sys.stdin.readline().rstrip() for _ in range(N)]

    result = find_unique_rotations(words_list)
    print(result)