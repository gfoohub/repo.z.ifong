#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100
#define NKEYS (sizeof keytab / sizeof(keytab[0]))
#define BUFSIZE 100

struct key {
	char *word;
	int count;
} keytab[] = {
	"auto",		0,
	"break",	0,
	"case",		0,
	"char",		0,
	"const",	0,
	"continue",	0,
	"default",	0,
	/* ... */
	"unsigned",	0,
	"void",		0,
	"volatile",	0,
	"while",	0
};


int getword(char *, int);
int binsearch(char *, struct key *, int);

char buf[BUFSIZE];    /* buffer for ungetch */
int bufp = 0;         /* next free position in buf �U�@�ӭn�i�쨺�Ӧ�m */

/* count C keywords */
main(){
	int n;
	char word[MAXWORD];

	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			if ((n = binsearch(word, keytab, NKEYS)) >= 0)
				keytab[n].count++;
	for (n = 0; n < NKEYS; n++)
		if (keytab[n].count > 0)
			printf("%4d %s\n",keytab[n].count, keytab[n].word);
	return 0;
} //end main

/* binsearch:  find word in tab[0]...tab[n-1] */
int binsearch(char *word, struct key tab[], int n){
	int cond;
	int low, high, mid;

	low = 0;
	high = n - 1;
	while (low <= high) {
		mid = (low+high) / 2;
		if ((cond = strcmp(word, tab[mid].word)) < 0){
			high = mid - 1;
		}
		else {	if (cond > 0)
				low = mid + 1;
			else
				return mid;
		}
	}
	return -1;
} // end binsearch

/* getword:  get next word or character from input */
int getword(char *word, int lim){
	int c, getch(void);
	void ungetch(int);
	char *w = word;

	// �p�i�Ӫ��O�ťիh�@������, �@�����줣�O�ťդ~���}
	while (isspace(c = getch()))
		;

	// �i�Ӫ����O eof �����Ÿ�, �]�N�O ^D �h�i�H��F���J
	if (c != EOF)
		*w++ = c;

	// �i�Ӫ��Ĥ@�Ӧr�O���O��r�r�� (a-z A-Z) �h�n���}, �]������r�n�H�r���}�l
	if (!isalpha(c)) {
		// ����
		*w = '\0';
		return c;
	}

	// isalnum ���զr�ŬO�_���^��μƦr, ������Ʀ� isalpha isdigit islower isupper
	// �`�N: �D�n��Ū�J�b��, �j���@�� word ��Ū�J
	for ( ; --lim > 0; w++){
		if (!isalnum(*w = getch())) {
			// �w�O�D��r�ΫD�Ʀr, �h��o�Ӧr��J buf[] ��
			ungetch(*w);
			break;
		}
	}
	// �[�J�r�ꪺ�����r��
	*w = '\0';

	// �Ǧ^�Ĥ@�Ӧr��
	return word[0];
} // end getword

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
