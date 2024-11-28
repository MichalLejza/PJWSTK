#include <iostream>
#include <cstdlib>
#include <utility>
#include <vector>
#include <string>
#include <algorithm>

class Person
{
    static size_t ID;
    std::string name;
    size_t id;
    std::vector<const Person*> friends;

public:

    explicit Person(std::string Name)
    {
        this -> name = std::move(Name);
        this -> id = ID++;
        this -> friends = std::vector<const Person *>();
    }

    auto makeFriends(Person &p) -> void
    {
        if(std::find(friends.begin(),friends.end(), &p) == friends.end())
        {
            this -> friends.push_back(&p);
            p.friends.push_back(this);
        }
    }

    auto listOfFriends() const -> void
    {
        std::cout << this -> name << "'s friends -> ";
        for(auto i : friends)
            std::cout << i -> info();
        std::cout << std::endl;
    }

    [[nodiscard]] std::vector<const Person *> friendsOfFriends() const
    {
        std::vector<const Person *> list = std::vector< const Person *>();
        for(auto p : friends)
            for(auto pP : p -> friends)
            {
                if(pP != this && pP != p)
                    list.push_back(pP);
            }
        return list;
    }

    [[nodiscard]] std::string info() const
    {
        std::string inf = "(" + std::to_string(this -> id) + ") ";
        return this -> name + inf;
    }


};
size_t Person::ID{1};

auto main() -> int
{
    Person john{"John"}, mary{"Mary"}, kitty{"Kitty"}, jill{"Jill"}, bob{"Bob"}, eve{"Eve"};
    john.makeFriends(mary); john.makeFriends(bob);john.makeFriends(eve);  bob.makeFriends(john);bob.makeFriends(jill);  bob.makeFriends(eve);eve.makeFriends(mary);  eve.makeFriends(kitty);
    john.listOfFriends();std::cout << "Friends of John’s friends -> ";
    for (const Person* p : john.friendsOfFriends())
        std::cout << p->info() << " ";
    std::cout << std::endl;
    return 0;
}

