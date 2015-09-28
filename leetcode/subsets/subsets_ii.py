def subsetsWithDup(nums):
    ans = [[]]
    for n in sorted(nums):
        currAns = list(ans)
        for l in currAns:
            newL = l + [n]
            if newL not in ans:
                ans.append(newL)
    return ans

if __name__ == '__main__':
    print subsetsWithDup([0])
