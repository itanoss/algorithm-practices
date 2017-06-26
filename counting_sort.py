
def counting_sort(arr):
    output = [0] * len(arr)
    count = [0] * 10
    for x in arr:
        count[x] += 1
    
    for i in range(1, len(count)):
        count[i] += count[i-1]
    
    for x in arr:
        output[count[x]-1] = x
        count[x] -= 1

    return output


arr = [1, 4, 1, 2, 7, 5, 2]
print(counting_sort(arr))
