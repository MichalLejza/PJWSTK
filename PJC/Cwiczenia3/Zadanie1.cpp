#include <algorithm>
#include <iostream>
#include <vector>

enum VERSION{EVEN, ODD, PRIME};

auto remove_if_enum(std::vector<int> &v, VERSION typ)
{
    auto ifPrime = [](int a) -> bool
    {
        if(a == 1)
            return false;
        for(int i = 2; i <= a / 2; i++)
            if(a % i == 0)
                return false;
        return true;
    };

    if(typ == 0)
    {
        auto range = std::remove_if(v.begin(), v.end(), [](int a) -> bool { return a % 2 == 0; });
        v.erase(range, v.end());
    }
    else if(typ == 1)
    {
        auto range = std::remove_if(v.begin(), v.end(), [](int a) -> bool { return a % 2 != 0; });
        v.erase(range, v.end());
    }
    else if(typ == 2)
    {
        auto range = std::remove_if(v.begin(), v.end(), ifPrime);
        v.erase(range, v.end());
    }
}

auto main() -> int
{
    std::vector<int> v={1,2,3,4,5,6,7,8,9,10};
    remove_if_enum(v, ODD);
    for(auto a : v)
        std::cout << a << " ";
    return 0;
}
