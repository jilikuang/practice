def canFinish(numCourses, prerequisites):
    numPres = {}
    for p in prerequisites:
        if p[0] in numPres:
            numPres[p[0]] += 1
        else:
            numPres[p[0]] = 1

    queue = []
    for i in range(numCourses):
        if i not in numPres:
            queue.append(i)

    taken = 0
    while queue:
        c = queue.pop(0)
        taken += 1
        for p in prerequisites:
            if c == p[1]:
                numPres[p[0]] -= 1
                if numPres[p[0]] == 0:
                    queue.append(p[0])

    return taken == numCourses

if __name__ == "__main__":
    print canFinish(3, [[1,0], [2,1]])
