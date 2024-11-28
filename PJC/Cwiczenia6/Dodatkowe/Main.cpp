#include <iostream>
#include <cstdlib>
#include <vector>
#include <fstream>
#include <regex>
#include <cstdio>

struct Point
{
    int x;
    int y;
    int z;

public:
    Point(int X, int Y, int Z)
    {
        this -> x = X;
        this -> y = Y;
        this -> z = Z;
    }
};

struct Object
{
    std::vector<Point> points;
    size_t numberOfPoints;
    double maxX, maxY, maxZ;
    double minX, minY, minZ;
};

std::vector<std::string> splitString(const std::string &s, const std::regex &sep = std::regex{"\\s+"})
{
    std::sregex_token_iterator iter(s.begin(), s.end(), sep, -1);
    std::sregex_token_iterator end;
    return {iter, end};
}

void fillObjects(const std::string& pathName)
{
    std::vector<std::string> lines = std::vector<std::string>();
    std::string linia;
    std::ifstream infile(pathName);
    while(std::getline(infile, linia))
        lines.push_back(linia);

    for(auto & line : lines)
        std::cout << line << std::endl;

    std::vector<Object *> objects = std::vector<Object *>();

    for(auto & line : lines)
    {
        auto *o = (Object *)(malloc(sizeof(Object)));
        std::vector<std::string> numbers = splitString(line);

        for(int j = 0; j < numbers.size(); j += 3)
        {
            Point p = Point(std::stoi(numbers.at(j)), std::stoi(numbers.at(j + 1)), std::stoi(numbers.at(j + 2)));
            o -> points.push_back(p);
        }

        objects.push_back(o);
    }


}



auto main() -> int
{
    fillObjects("/Users/michallejza/CLionProjects/PJC/Cwiczenia6/Dodatkowe/Dane.txt");
    return 0;
}
