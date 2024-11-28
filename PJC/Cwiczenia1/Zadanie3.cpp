#include <iostream>
#include <vector>

using std::cin, std::cout, std::vector, std::string;

auto printVector( vector<string> vec ) -> void
{
    for(auto s : vec)
        cout << s << " ";
}

auto sortAlfabet(vector<string> words) -> void
{
    for(int i = 0; i < words.size(); i++)
        for(int j = i; j < words.size(); j++)
            if(words[i].at(0) > words[j].at(0))
            {
                auto s = words[i];
                words[i] = words[j];
                words[j] = s;
            }
    printVector(words);
}

auto main() -> int
{
    auto vec = vector<string>();
    string word;
    for(int i = 0; i < 5; i++)
    {
        cin >> word;
        vec.push_back(word);
    }
    sortAlfabet(vec);
    return 0;
}
