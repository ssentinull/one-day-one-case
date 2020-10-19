#include <iostream>

using namespace std;

int main(){
    unsigned long long n, m, a;

    cin >> n >> m >> a ;

    unsigned long long numTilesWidth = n / a;

    if(n % a != 0)
        numTilesWidth += 1;

    unsigned long long numTilesHeight = m / a;

    if(m % a != 0)
        numTilesHeight += 1;

    cout << numTilesWidth * numTilesHeight;
}