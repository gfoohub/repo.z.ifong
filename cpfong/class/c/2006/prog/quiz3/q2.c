/*
2. �g�@�{���i�H�p�����L��J���Ҧ��r (���� EOF) ��, ���h�֭� a �� e (5 ��) 
���^��r, �Y��J��U a!Zb1 ��X���� a:1 b:1 c:0 d:0 e:0 other:5 (�`�N�b�P�@��)
*/

#include "stdio.h"
main(){
        int i,c;
        int a[6];
        char b[]="abcde";

        for (i=0;i<6;i++)
                a[i]=0;

        while ((c=getchar()) != EOF){
                if(c>='a' && c<='e'){
                        ++a[c-'a'];
                }
                else{
                        if(c!='\n'){++a[5];}
                }
        }

        for (i=0;i<5;i++){
                printf("%c:%d ",b[i],a[i]);
        }
        printf("other:%d\n",a[5]);
}
