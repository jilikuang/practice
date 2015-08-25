def two_sum(nums, target):
    table = {}
    ret = []
    for i in range(len(nums)):
        search = target - nums[i]
        if search in table:
            ret.append(table[search] + 1)
            ret.append(i + 1)
            break
        table[nums[i]] = i
    return ret

if __name__ == "__main__":
    nums = [0, 1, 4, 0]
    target = 0
    print two_sum(nums, target)
