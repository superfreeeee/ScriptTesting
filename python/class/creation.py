class A():
    
    name = 'superfree'
    age = 20

    def hi(self):
        print('my name is {}, i am {} years old now'.format(self.name, self.age))

if __name__ == '__main__':
    me = A()
    me.hi()