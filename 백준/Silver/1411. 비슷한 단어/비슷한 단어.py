import sys

def is_anagram(word1, word2):
    check1 = [0] * 26
    check2 = [0] * 26

    for k in range(len(word1)):
        idx1 = ord(word1[k]) - ord('a')
        idx2 = ord(word2[k]) - ord('a')

        if check1[idx1] == 0 and check2[idx2] == 0:
            check1[idx1] = word2[k]
            check2[idx2] = word1[k]
        elif check1[idx1] != word2[k]:
            return False

    return True

def main():
    n = int(sys.stdin.readline().strip())
    words = [sys.stdin.readline().strip() for i in range(n)]
    cnt = 0

    for i in range(n - 1):
        for j in range(i + 1, n):
            if is_anagram(words[i], words[j]):
                cnt += 1

    print(cnt)

if __name__ == "__main__":
    main()