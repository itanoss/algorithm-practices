
def counting_sort(arr, exp):
    output = [0] * len(arr)
    count = [0] * 10
    for x in arr:
        index = (x / exp) % 10
        count[index] += 1
    
    for i in range(1, len(count)):
        count[i] += count[i-1]
    
    # print(count)
    for i in range(len(arr)-1, -1, -1):
        x = arr[i]
        index = (x / exp) % 10
        output[count[index]-1] = x
        count[index] -= 1

    return output

def radix_sort(arr):
    maximum = max(arr)

    exp = 1
    while maximum / exp > 0:
        # print(arr)
        arr = counting_sort(arr, exp)
        exp *= 10
        
    return arr
    
arr = [ 170, 45, 75, 90, 802, 24, 2, 66]
print(radix_sort(arr))
