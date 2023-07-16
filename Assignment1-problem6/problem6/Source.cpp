
#include <iostream>
#include <list>
using namespace std;
class HashMapTable
{
	// size of the hash table
	int table_size;
	// Pointer to an array containing the keys
	list<int>* table;
public:
	
	HashMapTable(int key);
	int hashFunction(int key) {
		return (key % table_size);
	}
	
	void insertElement(int key);
	void deleteElement(int key);
	void displayHashTable();
};

HashMapTable::HashMapTable(int ts)
{
	this->table_size = ts;
	table = new list<int>[table_size];
}

void HashMapTable::insertElement(int key)
{
	int index = hashFunction(key);
	table[index].push_back(key);
}

void HashMapTable::deleteElement(int key)
{
	int index = hashFunction(key);

	list <int> ::iterator i;
	for (i = table[index].begin(); i != table[index].end(); i++)
	{
		if (*i == key)
			break;
	}

	if (i != table[index].end())
		table[index].erase(i);
}

void HashMapTable::displayHashTable() {
	for (int i = 0; i < table_size; i++) {
		cout << i;
	
		for (auto j : table[i])
			cout << " ==> " << j;
		cout << endl;
	}
}

int main()
{
	
	int arr[] = { 20, 34, 56, 54, 76, 87 };
	int n = sizeof(arr) / sizeof(arr[0]);
	// table_size of hash table as 6
	HashMapTable ht(6);
	for (int i = 0; i < n; i++)
		ht.insertElement(arr[i]);
	// deleting element 34 from the hash table
	ht.deleteElement(34);
	// displaying the final data of hash table
	ht.displayHashTable();
	return 0;
}