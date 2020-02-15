n, ac = list(map(int, input().split(' ')))
areas = []
for i in range(ac):
    areas.append(list(map(int, input().split(' '))))
count = 0
for m in range(0, n+1):
    for area in areas:
        if area[0] <= m <= area[1]:
            break
    else:
        count += 1
print(count)