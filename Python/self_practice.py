class Test:

    def __init__(self, key, value):
        self.key = key
        self.val = value

def main():
    print "This is the self practice of Python"
    a = Test(1, 1)
    b = Test(2, 2)
    d = {}
    d[a] = 'a'
    d[b] = 'b'
    print d

if __name__ == "__main__":
    main()
