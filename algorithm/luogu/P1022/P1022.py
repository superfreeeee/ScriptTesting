class Compute():

    def __init__(self, sentence):
        l, r = sentence.split('=')
        self.a = self.b = 0
        self.sign = ''
        self.produce(l, '+')
        self.produce(r, '-')
        self.result()

    def produce(self, line, mode):
        temp = 0
        positive = True
        isB = True
        for c in line:
            if '0' <= c <= '9':
                temp = temp * 10 + int(c)
            elif 'a' <= c <= 'z':
                isB = False
                self.sign = c
            else:
                if not positive:
                    temp *= -1
                if mode == '-':
                    temp *= -1
                if isB:
                    self.b += temp
                else:
                    self.a += temp
                temp = 0
                positive = c == '+'
                isB = True
        if not positive:
            temp *= -1
        if mode == '+':
            temp *= -1
        if isB:
            self.b += temp
        else:
            self.a += temp
        print(self.a, self.b)

    def result(self):
        print(self.sign+'='+str(-self.b/self.a))
        
if __name__ == '__main__':
    Compute(input())
