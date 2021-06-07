from collections import Counter 
    
def secondMostRepeated(input): 
    
    # Converting given list into dictionary 
    dict = Counter(input) 
    
    # Get list of all values then sort it in ascending order 
    value = sorted(dict.values(), reverse=True) 
    
    # Pick second repeated word
    secondRepeated = value[1] 
    
    # Traverse dictionary and print key whose 
    # value is equal to second repeated word
    for (key, val) in dict.items(): 
        if val == secondRepeated: 
            print (key) 
            return
        
    # Driver program 
if __name__ == "__main__": 
    input = ['aaa','bbb','ccc','bbb','aaa','aaa'] 
    secondMostRepeated(input)