#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

int main() {
    string input;

    getline(cin, input);

    stringstream ss(input);

    vector<string> words;

    string word;

    while (ss >> word) {
        words.push_back(word);
    }

    int count = words.size();

    cout << count << endl;

    return 0;
}