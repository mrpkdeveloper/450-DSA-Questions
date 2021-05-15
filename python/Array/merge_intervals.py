# Approach 1
def merge_intervals(intervals):
    out = []
    for i in sorted(intervals, key=lambda i: i[0]):
        if out and i[0] <= out[-1][-1]:
            out[-1][-1] = max(out[-1][-1], i[-1])
        else:
            out += i,
    return out

# merge_intervals([[1, 3], [2, 6]]) --> [[1, 6]]