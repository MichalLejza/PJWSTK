#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

auto move_by_vowels(std::vector<std::string> &words)
{
    auto comparator = [](std::string &a, std::string &b) -> bool {
        return a[0] == 'A' || a[0] == 'E' || a[0] == 'I' || a[0] == 'O' || a[0] == 'U';
    };
    std::sort(words.begin(), words.end(), comparator);
}

auto printVector(std::vector<std::string> vec)
{
    for(auto a : vec)
        std::cout << a << " ";
}

auto main() -> int
{
    std::vector<std::string> words = std::vector<std::string>();
    words.emplace_back("Hello");
    words.emplace_back("Kajtek");
    words.emplace_back("Alert");
    words.emplace_back("Elokwentnie");
    words.emplace_back("Krzysiek");
    words.emplace_back("Ula");
    move_by_vowels(words);
    printVector(words);
    return 0;
}