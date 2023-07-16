#include <iostream>
#include <unordered_set>
using namespace std;

int main()
{
    int arr[100];
    // int arr[] = { 1, 2, 3, 4, 5, 6 };

   
    int arr_size = sizeof(arr) / sizeof(arr[0]);
    cout << "size:";
    cin >> arr_size;
    
    cout << "Enter the nums:";
    for (int i = 0; i < arr_size; i++)
    {
        cin >> arr[i];
    }

    int minIndex = arr_size;

    unordered_set<int> set;

   
    for (int i = arr_size - 1; i >= 0; i--)
    {
        
        if (set.find(arr[i]) != set.end()) {
            minIndex = i;
        }
        
        else {
            set.insert(arr[i]);
        }

    }

    if (minIndex != -1)
    {
        cout << "The first repeating element is: " << arr[minIndex];
    }
       
    if (minIndex != arr_size) 
    {
        cout << "\nThe minimum index of the repeating element is: " << minIndex;
    }
    else 
    {
        cout << "Invalid Input :(";
    }

}