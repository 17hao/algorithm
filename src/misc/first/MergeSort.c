#include <stdio.h>

/**
 * merge sort
 * 
 * @since 2020-8-20 Thursday 15:11
 */

void mergeSort(int *arr, int s, int e);

int main(int argc, char *argv[])
{
    int arr[] = {1, 3, 2, 9, 1};
    int *p = arr;
    mergeSort(p, 0, 5);
    for (int i = 0; i < 5; i++)
    {
        printf("%d, ", p[i]);
    }
}

void merge(int *arr, int l, int r, int m)
{
    int n1 = m - l + 1, n2 = r - m;
    int left[n1], right[n2];

    for (int i = 0; i < n1; i++)
        left[i] = arr[l + i];

    for (int j = 0; j < n2; j++)
        right[j] = arr[m + j + 1];

    int i = 0, j = 0, index = l;

    while (i < n1 && j < n2)
    {
        if (left[i] < right[j])
            arr[index++] = left[i++];
        else
            arr[index++] = right[j++];
    }
    while (i < n1)
        arr[index++] = left[i++];
    while (j < n2)
        arr[index++] = right[j++];
}

void mergeSort(int *arr, int l, int r)
{
    if (l < r)
    {
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }
}