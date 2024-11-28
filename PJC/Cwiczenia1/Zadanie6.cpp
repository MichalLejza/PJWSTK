#include <iostream>
#include <vector>

using std::cin, std::cout, std::vector;

auto palindrom(vector<char> word, int a, int z) -> bool
{
    if(a < z)
    {
        if(word[a] == word[z])
            palindrom(word, a + 1, z - 1);
        else
            return false;
    }
    return true;
}

auto main() -> int
{
    if(palindrom({'a', 'l', 'a'}, 0, 2))
        cout << "jest";
    return 0;
}
