def solution(bridge_length, weight, truck_weights):

    
    ING = [0] * bridge_length
    time = 0
    while ING :
        ING.pop(0)
        time += 1
        
        if truck_weights :
            if (sum(ING) + truck_weights[0]) <= weight :
                ING.append(truck_weights.pop(0))
            else :
                ING.append(0)
        

        
        
        
        
    return time