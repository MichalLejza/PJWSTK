#include <iostream>
#include <cstdlib>
#include <vector>
#include <ctime>

struct Point
{
    double x, y;
public:
    ~Point()
    = default;

    Point(double x, double y)
    {
        this -> x = x;
        this -> y = y;
    }

    auto printPoint() const
    {
        std::cout << "[ " << this -> x << ", " << this -> y << " ]" << std::endl;
    }

    auto distanceFrom(Point *point) const -> double
    {
        double X = abs(point -> x - this -> x);
        double Y = abs(point -> y - this -> y);
        return sqrt(X * X + Y * Y);
    }

    auto changePoint(double x, double y) -> void
    {
        this -> x = x;
        this -> y = y;
    }
};

auto calculate(const std::vector<Point>& vec)
{
    auto minX = Point(INT32_MAX, 0);
    auto maxX = Point(INT32_MIN, 0);
    auto minY = Point(0, INT32_MAX);
    auto maxY = Point(0, INT32_MIN);

    for(const auto & i : vec)
    {
        if(i.x > maxX.x)
            maxX = i;

        if(i.x < minX.x)
            minX = i;

        if(i.y > maxY.y)
            maxY = i;

        if(i.y < minY.y)
            minY = i;
    }

    std::cout << "MAKS WARTOSCI!!" <<std::endl;
    maxX.printPoint();
    maxY.printPoint();
    minX.printPoint();
    minY.printPoint();
}


auto main() -> int
{
    srand(time(nullptr));
    std::vector<Point> vec = std::vector<Point>();

    for(int i = 0; i < 20; i++)
        vec.emplace_back(rand() % 40 - 20, rand() % 40 - 20);

    for(int i = 0; i < 20; i++)
        vec.at(i).printPoint();

    calculate(vec);

    return 0;
}
