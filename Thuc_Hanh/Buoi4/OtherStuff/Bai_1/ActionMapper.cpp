//
// Created by cycastic on 5/23/2023.
//

#include "ActionMapper.h"

ActionMapper::ActionMapper() = default;

ActionMapper& ActionMapper::map(const Function& fn) {
    functions_map.push_back(fn);
    return *this;
}

bool ActionMapper::prompt(void* passed) const {
    std::cout << "\nAction(s):\n\t0. Exit\n";
    unsigned int count = 1;
    for (const auto& function : functions_map){
        std::cout << "\t" << count++ << ". " << function.name << "\n";
    }
    std::cout << "Your input: ";
    unsigned int input;
    std::cin >> input;
    if (input == 0) return true;
    if (input - 1 >= functions_map.size()) return false;
    functions_map[input - 1].func(passed);
    return false;
}
