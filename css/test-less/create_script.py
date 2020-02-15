file_name_path = './file_name.txt'

try:
    f = False
    f = open(file_name_path, mode='r')
    file_names = f.read().split('\n')
except Exception as err:
    print('get file name err')
    print(err)
finally:
    if f:
        f.close()
print('scripts: \n')

i = 0
for name in file_names:
    print('\"m%d\": \"lessc src/%s/index.less > src/%s/index.css\",'%(i, name, name))
    i += 1

print('\nnpm all: \n')
ms = []
for i in range(len(file_names)):
    ms.append('npm run m%d'%i)

print(' && '.join(ms))
print('')
