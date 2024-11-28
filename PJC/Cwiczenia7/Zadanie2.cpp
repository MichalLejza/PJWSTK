#include <iostream>
#include <fstream>

auto printAll(std::string path) -> void
{
    auto file_iterator = std::filesystem::directory_iterator(path);
    if(file_iterator->exists())
    {
        for(auto file : file_iterator)
        {
            std::cout << file.path() << std::endl;
            if(file.is_directory())
            {
                printAll(file.path().string());
            }
        }
    }
}

auto main() -> int
{
    std::string path = "/Users/michallejza/CLionProjects/PJC/Cwiczenia7/Katalog1";
    printAll(path);
    return 0;
}
