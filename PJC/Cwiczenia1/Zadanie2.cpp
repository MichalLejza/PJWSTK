#include <iostream>
#include <vector>
#include <string>

auto printVector(std::vector<std::string> names) -> void
{
    for(auto s : names)
        std::cout << s << std::endl;
}

auto removeDuplicates(std::vector<std::string> names) -> void
{
    bool theSame = false;
    auto vec = std::vector<std::string>();

    for(auto s : names)
    {
        if(vec.empty())
            vec.push_back(s);
        else
        {
            for(auto r : vec)
                if(r.compare(s) == 0)
                    theSame = true;
            if(!theSame)
                vec.push_back(s);
            theSame = false;
        }
    }
    printVector(vec);
}

auto main() -> int
{
    auto names = std::vector<std::string>();
    std::string name;
    for(int i = 0; i < 10; i++)
    {
        std::cin >> name;
        names.push_back(name);
    }
    removeDuplicates(names);
    return 0;
}

