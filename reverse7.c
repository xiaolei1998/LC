#include <string.h>
#include <stdlib.h> 
#include <stdio.h> 

int reverse(int x){

    char input[33];
    unsigned int ux;
    
    int maxNum = pow(2,31)-1;
    char MAX[33] = {0};
    sprintf(MAX,"%d",maxNum);

    if(x>0){
        ux = x;
    }else{
        ux = (unsigned int)x;
    }

    sprintf(input,"%d",ux);
    char output[33] = {0};
    
    for(int i = strlen(input)-1, j = 0; i>=0;i--, j++){
        if(input[i] == '-'){
            continue;
        }
        output[j] = input[i];
    }


    if(strlen(output)<strlen(MAX)){
        if(x >= 0){
            return atoi(output);;
         }else{
            return 0-atoi(output);;
        }
    }else{
        if(strlen(output)>strlen(MAX)){
            return 0;
        }

        for(int i = 0; i < strlen(MAX); i++){
            if(MAX[i]-'0' == output[i]-'0'){
                continue;
            }

            if(MAX[i]-'0' > output[i] - '0'){
                if(x >= 0){
                    return atoi(output);
                }else{
                    return 0-atoi(output);
                }
    
            }

            if(MAX[i] - '0' < output[i]-'0'){
                return 0;
            }

        }

        
        
    }

    return 0;

}