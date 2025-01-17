
# Sort
정렬 알고리즘입니다.  
정렬을 제대로 작동원리부터 어떻게 구현을 해야하는지를 알아보기 위해 만들었습니다.


## BubbleSort
버블정렬 알고리즘입니다.  
비교 교환이 이뤄지며 전부 검사하기 때문에 성능이 좋지는 않습니다.
```java
public void sort(int[] arr) {
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                swap(arr,i,j);
            }
        }
    }
}
```
## SelectionSort
선택정렬 알고리즘입니다.  
교환 자체는 한번씩 이뤄지지만  
검사를 전체적으로 검사하기 때문에 성능은 안좋습니다.  
Bubble정렬보다는 좋습니다.
```java
void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if (min != i) {
            swap(arr, i, min);
        }
    }
}
```
## InsertionSort

선택 정렬 알고리즘입니다.  
index 1번부터 앞으로 검사하는 방향을 잡아  
앞에가 정렬되어있다면 빠르게 넘어가는 정렬 방식입니다.  
정렬이 되어있을 수록 성능이 뛰어납니다.
```java
void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
```
## ShellSort
쉘 정렬 알고리즘입니다.  
삽입 정렬의 단점을 보안한 정렬로 간격을 정하고 그 간격에 맞춰 정렬하는 방법으로 작동합니다.  
단점은 맨 마지막 요소가 index 0번째 들어가야하는 값이라면 O(n^2)의 복잡도를 가집니다.
```java
void sort(int[] arr) {
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < arr.length; i++) {
            for (int j = i; j >= gap; j -= gap) {
                int index = j - gap;
                if (arr[j] < arr[index]) {
                    swap(arr, j, index);
                }
            }
        }
    }
}
```
## MergeSort
병합 정렬 알고리즘입니다.  
배열을 2등분하여 최소 길이까지 나눈 다음, 합치면서 정렬하는 알고리즘으로  
O(nlog n)의 시간복잡도를 가지는 만큼 빠르다고 할 수 있습니다.  
다만 2등분 할 때마다 배열을 생성해줘야해서 O(2n)만큼의 공간복잡도를 가지고 있어 메모리 소모가 많아질 수 있습니다.
```java
void merge (int[] origin, int[] left, int[] right, int l, int r) {
    int index = 0, lIndex = 0, rIndex = 0;

    while (lIndex < l && rIndex < r) {
        if(left[lIndex] < right[rIndex]){
            origin[index] = left[lIndex++];
        } else {
            origin[index] = right[rIndex++];
        }
        index++;
    }

    while (lIndex < l) {
        origin[index++] = left[lIndex++];
    }
    while (rIndex < r) {
        origin[index++] = right[rIndex++];
    }
}

void mergeSort(int[] a, int n) {
    if(n < 2) return;
    int mid = n/2;
    int[] left = slice(a, 0, mid);
    int rightEnd = n - mid;
    int[] right = slice(a, mid, n);

    mergeSort(left, mid);
    mergeSort(right, rightEnd);
    merge(a, left, right, mid, rightEnd);
}
```
## HeapSort
힙 정렬 알고리즘입니다.  
최대 힙으로 배열을 정렬한 다음 힙 구조를 줄여가며 정렬하는 방법을 사용하였습니다.  
배열을 힙 자료구조로 사용할 경우 3가지 규칙이 존재합니다.
- 왼쪽 자식 노드 인덱스: 부모 인덱스 * 2
- 오른쪽 자식 노드 인덱스: 부모 인덱스 * 2 + 1
- 부모 노드 인덱스 찾기: (자식 인덱스 - 1) / 2

힙 자료구조로 만드는 만큼 계속 최대 힙을 유지해줘야하지만 시간 복잡도 자체는 빠른 편입니다.
```java
void sort(int[] a, int size) {
    int parentIdx = getParent(size - 1);
    // max heap
    for(int i = parentIdx; i >= 0; i--) {
        heapify(a, i, size - 1);
    }
    for(int i = size - 1; i > 0; i--) {
        swap(a, 0, i);
        heapify(a, 0, i - 1);
    }

}

int getParent(int child) {
    return (child - 1) / 2;
}


 void heapify(int[] a, int parentIdx, int lastIdx) {
    int leftChildIdx;
    int rightChildIdx;
    int largestIdx;

    while((parentIdx * 2) + 1 <= lastIdx) {
        leftChildIdx = (parentIdx * 2) + 1;
        rightChildIdx = (parentIdx * 2) + 2;
        largestIdx = parentIdx;


        if (a[leftChildIdx] > a[largestIdx]) {
            largestIdx = leftChildIdx;
        }

        if (rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]) {
            largestIdx = rightChildIdx;
        }

        if (largestIdx != parentIdx) {
            swap(a, parentIdx, largestIdx);
            parentIdx = largestIdx;
        }
        else {
            return;
        }
    }
}
```

## QuickSort
퀵 정렬 알고리즘입니다.
퀵 정렬 알고리즘은 pivot 지점을 찾는 것에 중점을 두고 있는데,  
이 지점을 찾을 때까지 왼쪽과 오른쪽의 데이터를 swap하면서 전체 배열의 정렬 밸런스를 잡아가면서,   
배열을 자르고 정렬 자르고 정력 하며 마지막에 합쳐 병합 정렬과 비슷합니다.  
다만 데이터를 크기 순으로 정렬하기 쉽게 배치가 되므로 빠른 알고리즘이라 할 수 있습니다.  
단점으로는 이미 정렬이 된 배열일 경우 O(n^2)의 성능이 나올 수 있습니다.  
퀵 정렬 알고리즘의 근본이 되는 pivot을 정하는 데에는 3가지 방법이 있습니다.
- 왼쪽 pivot 선택
- 오른쪽 pivot 선택
- 중간 pivot 선택
```java
void l_pivot_sort(int[] arr, int lo, int hi) {
    if(lo >= hi) return;
    int pivot = partition(arr, lo, hi);
    l_pivot_sort(arr, lo, pivot - 1);
    l_pivot_sort(arr, pivot + 1, hi);
}

int partition(int[] arr, int left, int right) {
    int lo = left;
    int hi = right;
    int pivot = arr[lo];
    while (lo < hi) {
        while (lo < hi && arr[hi] > pivot) hi--;
        while (lo < hi && arr[lo] <= pivot) lo++;
        swap(arr, lo, hi);
    }
    swap(arr, left, lo);
    return lo;
}
```
