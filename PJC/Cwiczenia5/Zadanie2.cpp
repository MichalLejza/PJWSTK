#include <iostream>
#include <vector>

template <typename T, typename Fun> auto repeat(T number, Fun fun) -> void
{
    if(number > 0)
    {
        fun();
        repeat(number - 1, fun);
    }
}

auto main() -> int
{
    repeat(4, []() -> void {std::cout << "Hello" << std::endl;});
    return 0;
}
