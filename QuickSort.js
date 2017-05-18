var quickSort = function(array) {
    var swap = function(a, b) {
        var buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    };

    var partition = function(p, r) {
        var q = p;
        for(var j = p; j < r; ++j) {
            if(array[j] <= array[r]) {
                swap(j, q++);
            }
        }
        swap(r, q);
        return q;
    };

    var execute = function(p, r) {
        if(p < r) {
            var q = partition(p, r);
            execute(p, q-1);
            execute(q+1, r);
        }
    }

    execute(0, array.length-1);
};


var sample = [3, 7, 8, 5, 2, 1, 9, 5, 4];
quickSort(sample);
console.log(sample);
