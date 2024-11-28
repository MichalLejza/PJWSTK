#include <iostream>
#include <string>
#include <vector>

template <typename T, typename Fun> auto mapped(std::vector<T> vec, Fun fun) -> std::vector<T>
{
    std::vector<T> vecR = std::vector<T>();
    for(const auto& a : vec)
        vecR.push_back(fun(a));
    return vecR;
}

auto main() -> int
{
    auto strings = std::vector<std::string>{"abc", "defghi", "jk", "lmnno"};

    auto chars = mapped(strings, [] (std::string s) -> std::string {return {s.front()};});

    for(const auto& a : chars)
        std::cout << a << " ";
    std::cout << "\n";

    auto sizes = mapped(strings, [](const std::string& s) -> std::string {return std::to_string(s.size());});

    for(const auto& a : sizes)
        std::cout << a << " ";
    std::cout << "\n";

    return 0;
}
