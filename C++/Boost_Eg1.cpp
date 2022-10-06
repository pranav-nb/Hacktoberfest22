/* C++ Program to demonstrate Big Integer data type
   Boost Libraries are intended to be widely useful, and usable across a broad spectrum of applications.
*/
#include<iostream>
#include<boost/multiprecision/cpp_int.hpp>

boost::multiprecision::int128_t boost_product(long long A, long long B) {
    boost::multiprecision::int128_t ans = (boost::multiprecision::int128_t)A * B;
    return ans;
}
 
int main(void) {
    long long first = 98745636214564698;
    long long second = 7459874565236544789;
    std::cout<<"Product of "<<first<<" * "<<second<< " = \n"<<boost_product(first, second);
    return 0;
}