/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* resultArray(int* nums, int numsSize, int* returnSize) {
    int* arr1 = (int*)malloc(numsSize * sizeof(int));
    int* arr2 = (int*)malloc(numsSize * sizeof(int));
    
    int arr1Size = 1, arr2Size = 1;
    arr1[0] = nums[0]; 
    arr2[0] = nums[1];  
    
    for(int i = 2; i < numsSize; i++) {
        if(arr1[arr1Size-1] > arr2[arr2Size-1]) {
            arr1[arr1Size++] = nums[i];  
        } else {
            arr2[arr2Size++] = nums[i];  
        }
    }

    int* result = (int*)malloc(numsSize * sizeof(int));
    *returnSize = numsSize;
    
    for(int i = 0; i < arr1Size; i++) {
        result[i] = arr1[i];
    }
    
    for(int i = 0; i < arr2Size; i++) {
        result[arr1Size + i] = arr2[i];
    }
    
    free(arr1);
    free(arr2);
    return result;
}