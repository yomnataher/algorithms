#include <iostream>
#include <unordered_map>
using namespace std;

int main()
{
    // int A[] = { 5, 4, 5, 5, 3, 1, 2, 2, 4 };
    int arr[100];

    int arr_size = sizeof(arr) / sizeof(arr[0]);
    cout << "size:";
    cin >> arr_size;

    cout << "Enter the nums:";
    for (int i = 0; i < arr_size; i++)
    {
        cin >> arr[i];
    }


    unordered_map<int, int> freq;


    for (int i = 0; i < arr_size; i++) {
        freq[arr[i]]++;
    }

    for (int i = 0; i < arr_size; i++)
    {

        if (freq.find(arr[i]) != freq.end())
        {

            int k = freq[arr[i]];
            while (k--) {
                cout << arr[i] << " ";
            }

            freq.erase(arr[i]);
        }
    }

    return 0;
}
