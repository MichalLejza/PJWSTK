#include <iostream>
#include <vector>

auto exchange_boundaries(std::vector<int> &numbers) -> void
{
    int min = 0;
    int max = 0;
    for(int i = 0; i < numbers.size(); i++)
    {
        if(numbers[min] < numbers[i])
            min = i;
        if(numbers[max] > numbers[i])
            max = i;
    }
    auto temp = numbers[min];
    numbers[min] = numbers[max];
    numbers[max] = temp;
}

auto printVector(const std::vector<int>& vec) -> void
{
    for(auto a : vec)
        std::cout << a << " ";
    std::cout << std::endl;
}

auto main() -> int
{
    std::vector<int> numbers = {2,5,7,9,1,10,-5,2};
    exchange_boundaries(numbers);
    printVector(numbers);
    return 0;
}
