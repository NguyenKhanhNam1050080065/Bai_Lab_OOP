//
// Created by cycastic on 5/23/2023.
//

#ifndef BAI_1_ACTIONMAPPER_H
#define BAI_1_ACTIONMAPPER_H

#include <utility>
#include <vector>
#include <iostream>

typedef void (*callback_fn)(void*);
struct Function {
    std::string name;
    callback_fn func;
    Function(std::string n, callback_fn fn) : name(std::move(n)), func(fn) {}
};

class ActionMapper {
private:
    std::vector<Function> functions_map;
public:
    ActionMapper();

    ActionMapper& map(const Function& fn);
    [[nodiscard]] bool prompt(void* passed) const;
};


#endif //BAI_1_ACTIONMAPPER_H
