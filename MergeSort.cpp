#include <iostream>

int buf[100];

void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void merge(int* arr, int lo, int mid, int hi) {
    int i = lo, j = mid+1, k = lo;
    while(i <= mid && j <= hi) {
        if(arr[i] < arr[j])
            buf[k++] = arr[i++];
        else
            buf[k++] = arr[j++];
    }
    if(i > mid)
        while(j <= hi)
            buf[k++] = arr[j++];
    if(j > hi)
        while(i <= mid)
            buf[k++] = arr[i++];
    
    for(int m = lo; m <= hi; m++)
        arr[m] = buf[m];
}

void mergesort(int* arr, int lo, int hi) {
    if(lo < hi) {
        int mid = (lo + hi) / 2;
        mergesort(arr, lo, mid);
        mergesort(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }
}

int main() {
    int sample[7] = {5, 3, 7, 6, 2, 1, 4};
    mergesort(sample, 0, 6);

    for(int i=0; i<7; i++)
        std::cout << sample[i] << ",";
}
