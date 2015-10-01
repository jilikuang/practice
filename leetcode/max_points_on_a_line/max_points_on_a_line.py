class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

def maxPoints(points):
    overall_max = 0
    for p1 in points:
        slopes = {}
        duplicates = 0
        verticals = 0
        for p2 in points:
            if p2.x == p1.x:
                if p2.y == p1.y:
                    duplicates += 1
                else:
                    verticals += 1
            else:
                slope = (p2.y - p1.y) / float(p2.x - p1.x)
                if slope in slopes:
                    slopes[slope] += 1
                else:
                    slopes[slope] = 1
        local_max = verticals
        for s in slopes:
            if slopes[s] > local_max:
                local_max = slopes[s]
        if local_max + duplicates > overall_max:
            overall_max = local_max + duplicates
    return overall_max

if __name__ == '__main__':
    points = []
    points.append(Point(-4, -4))
    points.append(Point(-8, -582))
    points.append(Point(-3, 3))
    points.append(Point(-9, -651))
    points.append(Point(9, 591))
    print maxPoints(points)
