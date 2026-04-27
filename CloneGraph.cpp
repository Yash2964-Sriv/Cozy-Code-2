/**
 * Basic DSA - Clone Graph (LeetCode 133)
 * Deep copy an undirected graph (each node has list of neighbors).
 */
#include <iostream>
#include <vector>
#include <unordered_map>

class Node {
public:
    int val;
    std::vector<Node*> neighbors;
    Node(int _val) : val(_val) {}
};

Node* cloneGraph(Node* node) {
    if (!node) return nullptr;
    std::unordered_map<Node*, Node*> vis;
    auto dfs = [&](auto&& self, Node* n) -> Node* {
        if (vis.count(n)) return vis[n];
        Node* copy = new Node(n->val);
        vis[n] = copy;
        for (Node* nb : n->neighbors)
            copy->neighbors.push_back(self(self, nb));
        return copy;
    };
    return dfs(dfs, node);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Clone Graph\n";
    std::cout << std::string(60, '=') << "\n";

    Node* a = new Node(1);
    Node* b = new Node(2);
    Node* c = new Node(3);
    Node* d = new Node(4);
    a->neighbors = {b, d};
    b->neighbors = {a, c};
    c->neighbors = {b, d};
    d->neighbors = {a, c};

    Node* clone = cloneGraph(a);
    std::cout << "Clone of [[2,4],[1,3],[2,4],[1,3]] -> val=" << clone->val
              << ", neighbors=" << clone->neighbors.size() << "\n";
}