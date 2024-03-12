from bisect import bisect_left, bisect_right

def count(words, left_value, right_value):
    right_index = bisect_right(words, right_value)
    left_index = bisect_left(words, left_value)
    
    return right_index - left_index
def solution(words, queries):
    answer = []
    
    data = [[] for _ in range(10001)]
    reverse = [[] for _ in range(10001)]
    for word in words:
        data[len(word)].append(word)
        reverse[len(word)].append(word[::-1])
    
    for i in range(10001):
        data[i].sort()
        reverse[i].sort()
        
    for query in queries:
        if query.startswith('?'):
            reversed_query = query[::-1]
            left_value = reversed_query.replace('?', 'a')
            right_value = reversed_query.replace('?', 'z')
            
            result = count(reverse[len(query)], left_value, right_value)
            
        else:
            left_value = query.replace('?', 'a')
            right_value = query.replace('?', 'z')
            
            result = count(data[len(query)], left_value, right_value)
        
        answer.append(result)
    return answer