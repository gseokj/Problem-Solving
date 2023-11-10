import sys

def count_matching_strings(target_str, str_list):
    ans = 0

    for alpha_str in str_list:
        if abs(len(alpha_str) - len(target_str)) > 1 or \
                len(set(target_str).difference(set(alpha_str))) > 1:
            continue

        for t in target_str:
            if t in alpha_str:
                alpha_str = alpha_str.replace(t, "", 1)

        if len(alpha_str) <= 1:
            ans += 1

    return ans

def main():
    N = int(input())
    target_str = input().strip()
    str_list = [input().strip() for _ in range(N - 1)]

    result = count_matching_strings(target_str, str_list)
    print(result)

if __name__ == "__main__":
    main()