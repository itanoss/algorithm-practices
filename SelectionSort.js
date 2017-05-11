var selectionSort = function(array) {
    var swap = function(a, b) {
        var buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    };
    
    var indexMin = function(startIndex) {
        var min = startIndex;
        for(var i = min+1; i < array.length; ++i) {
            if(array[min] > array[i]) {
                min = i;
            }
        }
        return min;
    };
    
    for(var i = 0; i < array.length; ++i) {
        var minIndex = indexMin(i);
        swap(i, minIndex);
    }
};

var sample = [3, 7, 8, 5, 2, 1, 9, 5, 4];
selectionSort(sample);
console.log(sample);
