#include <iostream>
#include <cstdlib>

using namespace std;

int main(){
    long long numCase;

    cin >> numCase;

    long long x1[numCase], 
        y1[numCase],
        x2[numCase],
        y2[numCase]; 

    for(int i = 0; i < numCase; i++){
        cin >> x1[i] >> y1[i] >> x2[i] >> y2[i];
    }

    long long numSteps[numCase];

    for(int i = 0; i < numCase; i++){
        if(x1[i] == x2[i] || y1[i] == y2[i]){
            numSteps[i] = abs(x1[i] - x2[i]) + abs(y1[i] - y2[i]);
        }else{
            numSteps[i] = abs(x1[i] - x2[i]) + abs(y1[i] - y2[i]) + 2;
        }
    }

    for(int i = 0; i < numCase; i++){
        cout << numSteps[i] << "\n";
    }
}