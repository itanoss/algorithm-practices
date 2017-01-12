#include <iostream>

void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int partition(int* arr, int lo, int hi) {
    int pivot = arr[hi];
    int i = lo;
    for(int j=lo; j<hi; ++j)
        if(arr[j] <= pivot)
            swap(arr, i++, j);
    swap(arr, i, hi);
    return i;
}

void quicksort(int* arr, int lo, int hi) {
    if(lo < hi) {
        int p = partition(arr, lo, hi);
        quicksort(arr, lo, p-1);
        quicksort(arr, p+1, hi);
    }
}

int main() {
    int sample[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    quicksort(sample, 0, 9);

    for(int i=0; i<10; i++)
        std::cout << sample[i] << ",";
}