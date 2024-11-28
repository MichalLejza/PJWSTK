#include <iostream>
#include <vector>

using std::cout, std::vector, std::string;

auto max(int a, int b) -> int
{
    return (a > b ? a : b);
}

auto upAndDown(char c, int size) -> void
{
    for(int i = 0; i < size + 2; i++)
        cout << c;
    cout << std::endl;
}

auto printWord(string word, int sizeMax, char znak) -> void
{
    cout << znak;
    for(int i = 0; i < sizeMax; i++)
    {
        if(i < word.size())
            cout << word.at(i);
        else
            cout << " ";
    }
    cout << znak << std::endl;
}

auto boxPrint(vector<string> words) -> void
{
    int size = 0;
    for(auto s : words)
        size = max(size, s.size());

    upAndDown('*', size);

    for(auto word : words)
        printWord(word, size, '*');

    upAndDown('*', size);
    cout << std::endl;
}


auto boxPrint(vector<string> words, char znak) -> void
{
    int size = 0;
    for(auto s : words)
        size = max(size, s.size());

    upAndDown(znak, size);

    for(auto word : words)
        printWord(word, size, znak);

    upAndDown(znak, size);
    cout << std::endl;
}

auto main() -> int
{
    boxPrint({"a", "quick", "brown", "fox"});
    boxPrint({"a", "quick", "brown", "fox"}, '*');
    boxPrint({"a", "quick", "brown", "fox"}, '#');
    boxPrint(std::vector<std::string>{"a", "quick", "brown", "fox"}, '#');
    boxPrint({""});
    boxPrint({});
    boxPrint({}, '#');
    boxPrint({"", "hmmmm", ""});
    boxPrint({"", "", ""});
    return 0;
}
