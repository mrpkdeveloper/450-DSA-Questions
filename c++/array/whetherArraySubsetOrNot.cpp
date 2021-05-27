#include <iostream>
#include <unordered_map>
using namespace std;

bool subsetOrNot(int arr1[], int arr2[], int size1, int size2)
{
	unordered_map<int, int> arrMap;
	for (int i = 0; i < size1; i++)
	{
		if (arrMap.count(arr1[i]) == 1)
		{
			arrMap[arr1[i]]++;
		}
		else
		{
			arrMap[arr1[i]] = 1;
		}
	}
	for (int i = 0; i < size2; i++)
	{
		if (arrMap.count(arr2[i]) == 0 || arrMap[arr2[i]] == 0)
		{
			return false;
		}
		arrMap[arr2[i]]--;
	}
	return true;
}

int main()
{
	int t;
	cin >> t;
	for (int x = 0; x < t; x++)
	{
		int size1, size2;
		cin >> size1 >> size2;
		int *arr1 = new int[size1];
		int *arr2 = new int[size2];
		for (int i = 0; i < size1; i++)
		{
			cin >> arr1[i];
		}
		for (int i = 0; i < size2; i++)
		{
			cin >> arr2[i];
		}
		bool ans = subsetOrNot(arr1, arr2, size1, size2);
		if (ans)
		{
			cout << "Yes" << endl;
		}
		else
		{
			cout << "No" << endl;
		}
		delete[] arr1;
		delete[] arr2;
	}
	return 0;
}