class Util():
    counter = 0
    
    def __init__(self):
        self.id = 0
        print('init:')
        print('id:', self.id)
        print('counter:', Util.counter)

    def increment_and_print_id(self):
        self.id += 1
        Util.counter += 1
        print('id:', self.id)
        print('counter:', Util.counter)


if __name__ == '__main__':
    util = Util()
    util.increment_and_print_id()
    util.increment_and_print_id()
    util.increment_and_print_id()
    
    util = Util()
    util.increment_and_print_id()
    util.increment_and_print_id()
    util.increment_and_print_id()
    