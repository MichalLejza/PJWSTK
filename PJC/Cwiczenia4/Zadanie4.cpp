#include <iostream>
#include <cstdlib>
#include <utility>
#include <vector>
#include <map>
#include <set>

/************************************************************************************/
// Struktura która zawiera nazwę węzła, wartość logiczną czy węzeł został odwiedzony
// Vector węzłów z którymi jest połączony oraz liczbę tych węzłów
/************************************************************************************/
struct Wezel
{
    std::string name;
    bool visited;
    std::vector<Wezel *> connectedTo;
    size_t numberOfConnectedNodes;
};
typedef struct Wezel Wezel;


/************************************************************************/
// Funkcja zwracający gotowy węzeł z alokowanymi wszystkimi wartościami
/************************************************************************/
auto createNewNode(std::string name)
{
    auto newNode = (Wezel *)(malloc(sizeof(Wezel)));
    newNode -> name = std::move(name);
    newNode -> visited = false;
    newNode -> numberOfConnectedNodes = 0;
    newNode -> connectedTo = std::vector<Wezel *>();
    return newNode;
}

/************************************************************************/
// Funkcja która tworzy vector z węzłami, czyli dodaje te węzły do którego
// dany węzeł może "iść"
/************************************************************************/
auto createConnections(Wezel *node, std::vector<Wezel *> connected, size_t numberOfNodes) -> void
{
    node -> numberOfConnectedNodes = numberOfNodes;
    for(int i = 0; i < numberOfNodes; i++)
        node -> connectedTo.push_back(connected.at(i));
}

/************************************************************************/
// Procedura void sprawdzająca czy z danego węzła możemy znaleźć cykl
// Procedura przyjmuje za argumenty wskaźnik do węzła i referencje do zmiennej
// króra przechowuje liczbę cykli które sa możliwe z danego węzła
/************************************************************************/
auto checkCycle(Wezel *node, int &ileCykli) -> void
{
    // jeśli natrafliśmy na węzeł już odwiedzony, to napewno ten graf jest cykliczny
    if(node -> visited)
    {
        ileCykli++;
        return;
    }
    for(int i = 0; i < node -> numberOfConnectedNodes; i++)
    {
        node -> visited = true;
        if(node -> connectedTo.at(i) != nullptr)
            checkCycle(node -> connectedTo.at(i), ileCykli);
        node -> visited = false;
    }
}

auto has_cycle(const std::map<std::string, std::set<std::string>>& graph) -> void
{
    auto setOfNodes =  std::set<std::string>();
    for(const auto& a : graph)
    {
        setOfNodes.insert(a.first);
        for(const auto& b : a.second)
            setOfNodes.insert(b);
    }

    auto vecOfNodes = std::vector<Wezel *>();
    for(const auto& a : setOfNodes)
        vecOfNodes.push_back(createNewNode(a));


    for(const auto& a : graph)
    {
        auto vecOfConnections = std::vector<Wezel *>();

        int i = 0;
        while (a.first != vecOfNodes.at(i) -> name)
            i++;

        for(const auto& b : a.second)
        {
            int j = 0;
            while (b != vecOfNodes.at(j) -> name)
                j++;
            vecOfConnections.push_back(vecOfNodes.at(j));
        }
        createConnections(vecOfNodes.at(i), vecOfConnections, a.second.size());
    }

    for(auto & Node : vecOfNodes)
    {
        int cykle = 0;
        checkCycle(Node, cykle);
        std::cout << "Wezel : " << Node -> name << " i liczba cykli: " << cykle << std::endl;
    }
}

auto main() -> int
{
    auto graph = std::map<std::string, std::set<std::string>>();
    graph["A"] = {"C", "B"};
    graph["B"] = {"C", "D"};
    graph["C"] = {"A"};
    graph["D"] = {"E"};
    graph["E"] = {"B"};

    has_cycle(graph);

    return 0;
}
