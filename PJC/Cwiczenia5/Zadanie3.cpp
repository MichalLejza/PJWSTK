#include <iostream>
#include <vector>
#include <string>

template <typename T> auto printVector(std::vector<T> vec) -> void
{
    for(const auto& a : vec)
        std::cout << a << " ";
    std::cout << std::endl;
}

auto main() -> int
{
    auto vec = std::vector<int>();
    vec = {1,2,3,4};
    printVector(vec);
    auto vec2 = std::vector<std::string>();
    vec2 = {"abc" , "def"};
    printVector(vec2);

    return 0;
}
