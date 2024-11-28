#include <iostream>
#include <vector>

using namespace std;

auto countChars(vector<char> letters, char a)
{
    int count = 0;
    for(auto c : letters)
        if(a == c)
            count++;
    return count;
}

auto countChars(string letters, char a) -> int
{
    int count = 0;
    for(auto c : letters)
        if(c == a)
            count++;
    return count;
}

auto main() -> int
{
    cout << countChars(std::vector<char>{'a', 'l', 'a'}, 'a') << '\n'
              << countChars("", 'a') << '\n'
              << countChars(std::string{'k', 'a', 'j', 'a', 'k'}, 'a') << '\n'
              << countChars(std::string("kajak"), 'k') << '\n'
              << countChars(std::vector<char>{'k', 'a', 'j', 'a', 'k'}, 'j') << '\n'
              << countChars("kajak", 'x') << '\n';

    return 0;
}