//
// Created by cycastic on 5/23/2023.
//

#include "NumberVector.h"

#define SWAP(m_x, m_y) __swap_tmpl((m_x), (m_y))
template <class T>
inline void __swap_tmpl(T &x, T &y) {
    T aux = x;
    x = y;
    y = aux;
}


int NumberVector::b_search_internal(const std::vector<long> &arr, const int &l_bound, const int &r_bound,
                                    const long &what) {
    if (r_bound >= 1 && l_bound != r_bound && l_bound < arr.size() && r_bound < arr.size()) {
        int idx = l_bound + (r_bound - 1) / 2;
        if (arr[idx] == what) return idx;
        if (arr[idx] > what) return b_search_internal(arr, l_bound, idx - 1, what);
        return b_search_internal(arr, idx + 1, r_bound, what);
    }
    return -1;
}

void NumberVector::insertion_sort() {
    for (int i = 1; i < size(); i++) {
        long key = this->operator[](i);
        int j = i - 1;
        while (j >= 0 && this->operator[](j) > key){
            this->operator[](j + 1) = this->operator[](j);
            j -= 1;
        }
        this->operator[](j + 1) = key;
    }
}

void NumberVector::s_sort_internal(std::vector<long> &v) {
    int i, j, min_idx;
    for (i = 0; i < v.size() - 1; i++)
    {
        min_idx = i;
        for (j = i + 1; j < v.size(); j++)
        {
            if (v[j] < v[min_idx])
                min_idx = j;
        }
        if (min_idx!=i)
            SWAP(v[min_idx], v[i]);
    }
}

void NumberVector::bubble_sort() {
    for (int i = 0; i < size() - 1; i++) {
        for (int j = i + 1; j < size(); j++) {
            auto& left = this->operator[](i);
            auto& right = this->operator[](j);
            if (left > right) {
                auto temp = left;
                left = right;
                right = temp;
            }
        }
    }
}
