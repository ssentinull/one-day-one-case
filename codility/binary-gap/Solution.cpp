int solution(int N) {
    
    // returns early if the number is 0
    if (N <= 0)
        return 0;

    int num = N;
    int binaryArray[32];

    // convert int to string array of binary values
    for(int i = 0; i < 32; ++i)
        binaryArray[i] = (num >> i) & 1;

    // output the binary array
    // cout<<"Binary Value: ";
    
    // for(int i = 31; i > 0; i--)
    //     cout<<binaryArray[i];

    int maxBinaryGap = 0;
    int binaryGapCounter = 0;
    int state = 0;

    for(int i = 31; i > 0; i--){

        // change the state from 'not counting' to 'counting' state
        if(state == 0 && binaryArray[i] == 1)
            state = 1;

        // increment the binary gap counter
        if(state == 1 && binaryArray[i] != 1)
            binaryGapCounter++;

        // when encountering the second 1 value, check if the binary gap counter value
        // is bigger than the current max value for binary gap
        if(state == 1 && binaryArray[i] == 1){
            if(binaryGapCounter > maxBinaryGap)
                maxBinaryGap = binaryGapCounter;
            binaryGapCounter = 0;
        }
    }

    return maxBinaryGap;
}