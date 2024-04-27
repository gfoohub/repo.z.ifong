#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100
#define NKEYS (sizeof keytab / sizeof(keytab[0]))
#define BUFSIZE 100

char buf[BUFSIZE];    /* buffer for ungetch */
int bufp = 0;         /* next free position in buf �U�@�ӭn�i�쨺�Ӧ�m */

/* count C keywords */
main(){
	int c, getch(void);
	void ungetch(int);
	char word[MAXWORD];
	int lim=20;
	char *w = word;

	// isalnum ���զr�ŬO�_���^��μƦr, ������Ʀ� isalpha isdigit islower isupper
	// �`�N: �D�n��Ū�J�b��, �j���@�� word ��Ū�J
	for ( ; --lim > 0; w++){
		if (!isalnum(*w = getch())) {
//			ungetch(*w);
			break;
		}
	}
	// �[�J�r�ꪺ�����r��
	*w = '\0';

	printf("word = %s", word);
} // end main

/* 
   get a (possibly pushed-back) character
   �p�G buffer ���٦��r�h�� buf ����, �_�h�� stdin ���r
   ���e���� bufp -- �]�� bufp �w�q���U�@�ӭn��J����m
*/
int getch(void){
       return (bufp > 0) ? buf[--bufp] : getchar();
} // end getch

/* 
   push character back on input 
   ��@�Ӧr����� buf �H�� getch �Ө�
*/
void ungetch(int c){
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
} // end ungetch
