#include <iostream>
#include <filesystem>
#include <string>
#include <fstream>

struct Osoba {
    std::string name, surname;
    Osoba(const std::string &name, const std::string &surname) : name(name), surname(surname) {}
    virtual auto print() const ->void{
        std::cout<<name<<" "<<surname<<"\n";
    }
    const std::string &getName() const {
        return name;
    }
    const std::string &getSurname() const {
        return surname;
    }
};

struct Student : public Osoba {
    int number;
    Student(const std::string &name, const std::string &surname, int number) : Osoba(name, surname), number(number) {}
    auto print() const ->void override{
        std::cout<<name<<" "<<surname<<" "<<number<<"\n";
    }
};

void getInfo(const Osoba& o)
{
    o.print();
}
int main() {
    Osoba o1 = Osoba("A","A");
    Osoba *s1 = new Student("B","B",1);
    getInfo(o1);
    getInfo(*s1);
    o1.print();
    s1 -> print();
    std::filesystem::path p=std::filesystem::current_path();
    p.parent_path();

    std::string path = "";

    auto file_iterator = std::filesystem::directory_iterator(path);

    for( auto file : file_iterator)
    {
        if(file.is_directory()) //recursion
        std::cout<<file.path().string()<<"\n";
    }
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
