nums = input()[:13].split('-')
string = ''.join(nums[0:3])
sum = 0
for i in range(9):
    sum += (i+1) * int(string[i])
sum %= 11
if sum == 10:
    sum = 'X'
else:
    sum = str(sum)

if sum == nums[3].split('\n')[0]:
    print('Right')
else:
    nums = nums[:3]
    nums.append(sum)
    print('-'.join(nums))
