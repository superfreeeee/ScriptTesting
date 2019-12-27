n = int(input())
nums = list(map(int, input().split(' ')))
count = 0
for i in range(n):
    for j in range(n):
        for k in range(j+1, n):
            if i == j or k == j:
                continue
            if nums[i] == nums[j] + nums[k]:
                count += 1
                break
        else:
            continue
        break
print(count)