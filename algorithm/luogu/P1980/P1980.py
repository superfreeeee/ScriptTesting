n, x = input().split(' ')
count = 0
for i in range(1, int(n)+1):
    for c in str(i):
        if c == x:
            count += 1
print(count)

