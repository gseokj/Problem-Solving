def count_brace_pairs(s):
    stack = []
    count = 0

    for char in s:
        if not stack and char == '}':
            count += 1
            stack.append('{')
        elif stack and char == '}':
            stack.pop()
        else:
            stack.append(char)

    count += len(stack) // 2
    return count

result = []

while True:
    s = input()
    if '-' in s:
        break
    result.append(count_brace_pairs(s))

for i, count in enumerate(result, start=1):
    print(f"{i}. {count}")
