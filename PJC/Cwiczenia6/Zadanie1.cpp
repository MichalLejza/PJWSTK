#include <iostream>
#include <cstdlib>
#include <string>

struct Student
{
    std::string imie;
    std::string nazwisko;
    std::string numerStudenta;
};

auto zmienImie1(Student student)
{
    student.imie = "Zmiana1";
}

auto zmienImie2(Student &student)
{
    student.imie = "Zmiana2";
}

auto zmienImie3(Student *student)
{
    student -> imie = "Zmiana3";
}

auto printStudent(Student *student)
{
    std::cout << student -> imie << " " << student -> nazwisko << " " << student -> numerStudenta << std::endl;
}

auto main() -> int
{
    auto *student = (Student *)malloc(sizeof(Student));
    student -> imie = "Andrzej";
    student -> nazwisko = "Golota";
    student -> numerStudenta = "s26690";

    printStudent(student);

    zmienImie1(*student);

    printStudent(student);

    zmienImie2(*student);

    printStudent(student);

    zmienImie3(student);

    printStudent(student);

    return 0;
}
