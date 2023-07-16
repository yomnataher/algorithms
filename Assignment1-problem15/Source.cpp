#include <bits/stdc++.h>
#include <unordered_set>
using namespace std;

bool Pair(int arr[] , int arr_size,int target )
{

    unordered_set<int> s;

    for (int i = 0; i < arr_size; i++)
    {
        int temp = target - arr[i];

        if (s.find(temp) != s.end())
            cout << "Pair is(" << arr[i] << "," << temp << ")" << endl;
        s.insert(arr[i]);
    }

   
   return 0;
}

int main(void)
{
    int arr[100];
    
    int arr_size = sizeof(arr) / sizeof(arr[0]);
    int target;

    cout << "size:";
    cin >> arr_size;

    cout << "Enter the nums:" << endl;
    for (int i = 0; i < arr_size; i++)
    {
        cin >> arr[i];
    }

    cout << "Enter the target:" << endl;
    cin >> target;

  
      
    if(Pair(arr, arr_size, target))
    {
        cout << "Pair Found :)" << endl;
    }
    else
    {
        cout << "Pair not found :(" << endl;

    }
    

    return 0;
}