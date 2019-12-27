total = 0
current, days = list(map(int, input().split(' ')))
if days > 7:
    total += 250 * 5 * int(days / 7)
    days %= 7
while days > 0:
    if 1 <= current <= 5:
        total += 250
    current = current % 7 + 1
    days -= 1
print(total)