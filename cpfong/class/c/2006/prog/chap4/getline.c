#include "stdio.h"
 
/*
	��@�檺���Ū�J s �}�C��Ǧ^���Ū�J����ƪ����� 
	�C�檺�̤j�r�Ƥ��i�H�W�L lim
*/
int getline(char s[], int lim){
	int c,i;
	i=0;

	while(--lim>0 && (c=getchar()) != EOF && c!='\n')
		s[i++]=c;
	if (c=='\n')
		s[i++]=c;
	s[i]='\0'; // �b�r�ꪺ�̥��[�@�ӵ����Ÿ�
	return i;
}
