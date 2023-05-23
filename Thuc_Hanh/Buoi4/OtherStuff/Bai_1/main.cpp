#include <iostream>
#include "NumberVector.h"
#include "ActionMapper.h"

int main() {
    NumberVector vec{ 0, 1, -3, 9, 32, 4, -17 };
    ActionMapper mapper{};
    mapper
            .map(Function("Binary search", [](void* passed){
                auto vec = reinterpret_cast<NumberVector*>(passed);
                std::cout << "Searching for -3: " << vec->binary_search(-3);
            }))
            .map(Function("Sequential search", [](void* passed){
                auto vec = reinterpret_cast<NumberVector*>(passed);
                std::cout << "Searching for -4: " << vec->binary_search(-4);
            }))
            .map(Function("Insertion sort", [](void* passed){
                auto vec = reinterpret_cast<NumberVector*>(passed);
                vec->insertion_sort();
                std::cout << "Sorted: " << vec->stringify();
            }))
            .map(Function("Selection sort", [](void* passed){
                auto vec = reinterpret_cast<NumberVector*>(passed);
                vec->selection_sort();
                std::cout << "Sorted: " << vec->stringify();
            }))
            .map(Function("Bubble sort", [](void* passed){
                auto vec = reinterpret_cast<NumberVector*>(passed);
                vec->bubble_sort();
                std::cout << "Sorted: " << vec->stringify();
            }));
    while (!mapper.prompt(&vec)){}
    return 0;
}
