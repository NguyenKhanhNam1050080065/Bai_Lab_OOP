//
// Created by cycastic on 5/23/2023.
//

#ifndef BAI_1_NUMBERVECTOR_H
#define BAI_1_NUMBERVECTOR_H

#include <vector>
#include <iostream>
#include <initializer_list>

class NumberVector : public std::vector<long> {
    static int b_search_internal(const std::vector<long>& arr, const int& l_bound, const int& r_bound, const long& what);
    static void s_sort_internal(std::vector<long>& v);
public:
    NumberVector() : std::vector<long>() {}
    NumberVector(const std::initializer_list<long>& list) : std::vector<long>(list) {}
    [[nodiscard]] inline int binary_search(const long& what) const {
        return b_search_internal(*this, 0, size() - 1, what);
    }
    [[nodiscard]] inline int sequential_search(const long& what) const {
        int re = 0;
        for (const auto& E : *this){
            if (what == E) return re;
            re++;
        }
        return -1;
    }
    void insertion_sort();
    inline void selection_sort() { s_sort_internal(*this); }
    void bubble_sort();
    [[nodiscard]] inline std::string stringify() const {
        std::string re = "";
        for (const auto& val : *this){
            re += std::to_string(val) + " ";
        }
        return re;
    }
};

#endif //BAI_1_NUMBERVECTOR_H
