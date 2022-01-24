# include <stdio.h>
# include <stdlib.h>

/*
    公元五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
    现要求你打印出所有花一百元买一百只鸡的方式。
*/

int main(){

    //Method 1: use formula to determine relationship
    /*
    5a + 5b + (100-a-b)/3 = 100;
    b = 25 - 7/4 a
    so a should be multiple of 4. and the upperbund of a should be 12;
    */
    for(int a = 0; a <= 12; a=a +4){
        float b = 25-(7/(float)4)*a;
        printf("%d ",a);
        printf("%d ",(int)b);
        printf("%d\n",(int)(100-a-b));
    }


    //Method 2: Violate solution
    /*
    tow for loop,   a in range[0...20]    b in range[0...33]
    */
   for(int a = 0; a<= 20; a++){
       for(int b = 0; b <= 33; b++){
           if(5*a + 3*b + (100-a-b)*(1/(float)3) == 100){
             printf("%d %d %d\n", a, b, 100-a-b);
           }
       }
   }

    return 0;
}