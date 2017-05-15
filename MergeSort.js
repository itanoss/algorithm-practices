var mergeSort = function(array) {
    var merge = function(array, p, q, r) {
        var lowHalf = [], highHalf = [], i = 0, j = 0, k = p;
        while(k<=q) {
            lowHalf[i++] = array[k++];
        }
        while(k<=r) {
            highHalf[j++] = array[k++];
        }

        i = 0, j = 0, k = p;
        while(i<=q-p && j<=r-q-1) {
            array[k++] = lowHalf[i] < highHalf[j] ? lowHalf[i++] : highHalf[j++];
        }
        console.log(array);

        while(i<=q-p) {
            array[k++] = lowHalf[i++];
        }
        while(j<=r-q-1) {
            array[k++] = highHalf[j++];
        }
        console.log(array);
    };

    var execute = function(array, p, r) {
        if(p<r) {
            var q = Math.floor((p+r)/2);
            execute(array, p, q);
            execute(array, q+1, r);
            merge(array, p, q, r);
        }
    };

    execute(array, 0, array.length-1);
};

var sample = [3, 7, 8, 5, 2, 1, 9, 5, 4];
mergeSort(sample);
console.log(sample);
