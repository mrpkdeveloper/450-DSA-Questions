class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort(key=lambda parameter_list: parameter_list[0])
        i = 0
        while i < len(intervals):
            if i+1 < len(intervals) and intervals[i][1] >= intervals[i+1][1]:
                # final_array.append(intervals[i])
                intervals.pop(i+1)
            elif i+1 < len(intervals) and intervals[i][1] >= intervals[i+1][0]:
                intervals[i] = ([intervals[i][0], intervals[i+1][1]])
                intervals.pop(i+1)
            else:
                i += 1

        return (intervals)