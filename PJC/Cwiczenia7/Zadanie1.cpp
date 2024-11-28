#include <iostream>
#include <fstream>

auto wypiszSciezki(std::string path) -> void
{
    auto file_iterator = std::filesystem::directory_iterator(path);
    for(auto file : file_iterator)
        std::cout << file.path() << std::endl;
}

auto wypiszPlik(std::string path)
{
    auto file_iterator = std::filesystem::directory_iterator(path);
    for(auto file : file_iterator)
    {
        if(std::filesystem::path(file).extension() == ".txt")
        {
            std::ifstream f (file);
            if(f.is_open())
                std::cout << f.rdbuf();
            break;
        }
    }
}

auto main() -> int
{
    std::string path = "/Users/michallejza/CLionProjects/PJC/Cwiczenia7/Katalog1";
    wypiszSciezki(path);
    wypiszPlik(path);
    return 0;
}
