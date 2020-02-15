n = int(input())
fishes = list(map(int, input().split(' ')))
result = []

for i in range(n):
    count = 0
    for j in range(i):
        if fishes[j] < fishes[i]:
            count += 1
    result.append(str(count))
print(' '.join(result))