#include <iostream>
#include <vector>

using std::cin, std::cout, std::vector;

auto change(int i, int j, int tab[]) -> void
{
    int temp = tab[i];
    tab[i] = tab[j];
    tab[j] = temp;
}

auto sort(int tab[], size_t size) -> void
{
    for(int i = 0; i < size; i++)
        for(int j = i; j < size; j++)
            if(tab[i] > tab[j])
                change(i, j, tab);
}

auto compare(int first[], int second[]) -> bool
{
    sort(first, 5);
    sort(second, 5);
    for(int i = 0; i < 5; i++)
        if(first[i] != second[i])
            return false;
    return true;
}

auto main() -> int
{
    int first[5];
    int second[5];

    for(int i = 0; i < 5; i++)
        cin >> first[i];
    for(int i = 0; i < 5; i++)
        cin >> second[i];

    if(compare(first, second))
        cout << "Yes";
    else
        cout << "no";

    return 0;
}
