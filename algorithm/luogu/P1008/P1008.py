for i in range(100, 334):
    a, b, c = i, i*2, i*3
    nums = list(str(a)+str(b)+str(c))
    if len(list(set(nums))) == 9 and not '0' in nums:
        print(a, b, c)