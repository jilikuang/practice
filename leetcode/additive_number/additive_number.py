def check(n1, n2, num):
    if n1 + n2 == int(num):
        return True
    if n1 + n2 > int(num):
        return False
    for ir in range(1, len(num)):
        n3 = num[:ir]
        rest = num[ir:]
        if rest[0] == '0':
            continue
        if n1 + n2 == int(n3) and check(n2, int(n3), rest):
            return True
    return False

def additive_number(num):
    for i2 in range(1, len(num)-1):
        for i3 in range(i2+1, len(num)):
            n1 = num[:i2]
            n2 = num[i2:i3]
            rest = num[i3:]
            if rest[0] == '0':
                continue
            if check(int(n1), int(n2), rest):
                return True
            if num[i2] == '0':
                break
    return False

if __name__ == '__main__':
    num = '112358'
    print additive_number(num)
