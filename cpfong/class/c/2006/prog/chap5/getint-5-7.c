#include "stdio.h"
#include "ctype.h"

int getch(void);
void ungetch(int);

/* 
	�� stdin Ū�J�@�� integer �B��J *pn
	�I�s�H���ܼƦ�}�ǤJ, �{���H pointer ��ȩ�^.
	�Ǧ^�ȫh��ܬO�_�� EOF �����A, 0 ���O EOF, 
	�_�h��ܬO EOF
*/

int getint(int *pn){
	int c, sign;

	// ����ťյ�����
	while (isspace(c=getch()))
		;

	// ���O�ҿת��Ʀr, �Y���O + - EOF 0-9
	if (!isdigit(c) && c != EOF && c != '+' && c!= '-'){
		ungetch(c);
		// debug
		// printf("pre-return, *pn not defined yet!\n");
		return 0;
	}

	// ���t��, �h sign �ܼƬ� 1 �� -1 �H�K���@�U��
	sign = (c == '-') ? -1 : 1;

	// �p�G�Ĥ@�r�������t��, �h���J�ĤG�r��
	if (c == '+' || c == '-')
		c=getch();

	for (*pn=0; isdigit(c); c=getch())
		*pn = 10 * *pn + (c - '0');

	*pn *= sign;

	if (c != EOF)
		ungetch(c);
	return c;
}
