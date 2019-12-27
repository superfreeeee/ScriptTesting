n = int(input())
temps = list(map(int, input().split(' ')))
count = 0
t = temps[0]
c = 1
for i in range(1, n):
    if t < temps[i]:
        c += 1
    else:
        if c > count:
            count = c
        c = 1
    t = temps[i]
if c > count:
    count = c
print(count)