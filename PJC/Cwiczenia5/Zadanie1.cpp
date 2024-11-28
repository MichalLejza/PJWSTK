#include <iostream>
#include <fstream>

auto main() -> int
{
    auto file = std::fstream ("/Users/michallejza/CLionProjects/PJC/Cwiczenia5/Plik.txt", std::ios_base::in);
    int number;
    int sum = 0;
    while (file >> number)
        sum += number;
    std::cout << "Suma: " << sum;
    return 0;
}
