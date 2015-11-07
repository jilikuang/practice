def merge(bl, br):
    ans = []
    hl, hr = 0, 0
    while bl and br:
        if bl[0][0] < br[0][0]:
            x = bl[0][0]
            hl = bl[0][1]
            h = max(hl, hr)
            bl.pop(0)
        elif bl[0][0] > br[0][0]:
            x = br[0][0]
            hr = br[0][1]
            h = max(hl, hr)
            br.pop(0)
        else:
            x = bl[0][0]
            hl = bl[0][1]
            hr = br[0][1]
            h = max(hl, hr)
            br.pop(0)
            bl.pop(0)
        if not ans or ans[-1][1] != h:
            ans.append([x, h])
    ans += bl
    ans += br
    return ans

def get_skyline(buildings, s, e):
    if s < e:
        m = (s + e) / 2
        bl = get_skyline(buildings, s, m)
        br = get_skyline(buildings, m+1, e)
        ans = merge(bl, br)
    else:
        rise = [buildings[s][0], buildings[s][2]]
        down = [buildings[s][1], 0]
        ans = [rise, down]
    return ans

if __name__ == '__main__':
    buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
    #buildings = [[1,2,1],[1,2,2],[1,2,3]]
    #buildings = [[0,2,3],[2,5,3]]
    print get_skyline(buildings, 0, len(buildings)-1)
