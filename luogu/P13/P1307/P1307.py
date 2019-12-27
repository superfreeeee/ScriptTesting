num = input()
if '-' not in num:
    print(int(num[::-1]))
else:
    print('-',end='')
    print(int(num[:0:-1]))