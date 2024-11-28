#include <iostream>
#include <vector>

std::vector<std::vector<int>> split_on_median(std::vector<int> numbers)
{
    std::vector<std::vector<int>> wektory = std::vector<std::vector<int>>();
    std::sort(numbers.begin(), numbers.end());
    std::vector<int> pierwszy = std::vector<int>();
    std::vector<int> drugi = std::vector<int>();
    int i = 0;
    for(; i < numbers.size() / 2; i++)
        pierwszy.push_back(numbers.at(i));
    for(; i < numbers.size(); i++)
        drugi.push_back(numbers.at(i));
    wektory.push_back(pierwszy);
    wektory.push_back(drugi);
    return wektory;
}

auto printVector(const std::vector<int> &vec)
{
    for(auto a : vec)
        std::cout << a << " ";
    std::cout << std::endl;
}

auto main() -> int
{
    auto wektory = split_on_median({3,4,5,8,1,2,7,6});
    for(const auto &a : wektory)
        printVector(a);
    return 0;
}
