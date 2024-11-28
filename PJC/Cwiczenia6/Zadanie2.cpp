#include <iostream>
#include <cstdlib>
#include <utility>
#include <vector>


struct Student
{
    std::string imie;
    std::string nazwisko;
    std::string numerStudenta;
    int numerSemestru;
};
typedef struct Student Student;

auto createStudent(std::string imie, std::string nazwisko, std::string numerStudenta, int numerSemestru) -> Student *
{
    auto *newStudent = (Student *)(malloc(sizeof(Student)));
    newStudent -> imie = std::move(imie);
    newStudent -> nazwisko = std::move(nazwisko);
    newStudent -> numerStudenta = std::move(numerStudenta);
    newStudent -> numerSemestru = numerSemestru;
    return newStudent;
}

auto checkIfAll(const std::vector<Student *> &studenci) -> bool
{
    return (std::all_of(studenci.begin(), studenci.end(), [&](Student * a) {return a -> numerSemestru == studenci.at(0) -> numerSemestru;}));
}

auto main() -> int
{
    std::vector<Student *> studenci = std::vector<Student *>();
    studenci.push_back(createStudent("Jacek", "Ziolkowski", "s26690", 1));
    studenci.push_back(createStudent("Maciej", "Malkowski", "s26692", 1));
    std::cout << checkIfAll(studenci);
    return 0;
}

