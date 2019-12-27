target = float(input())
step = 2
total = 0
count = 0
while total < target:
    total += step
    count += 1
    step *= 0.98
print(count)