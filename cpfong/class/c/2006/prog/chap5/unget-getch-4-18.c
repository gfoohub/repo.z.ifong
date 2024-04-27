// �w�q�o���{�ɪ��Ȧs�� (buffer) ���j�p
#define	BUFSIZE 100

// ��F�誺�Ȧs�� array
char buf[BUFSIZE];

// buffer ������, �Ψӫ��U�@�ӥi�Ϊ���}
int bufp = 0;

// �p�G buffer �����F��h�� buffer ����, �_�h�� stdin ���J�r��
int getch(void){
	return (bufp > 0) ? buf[--bufp] : getchar();
} // end getch

// �p�G buffer �٥i�H��F��, �h��@�Ӧr��J buffer ����
void ungetch(int c){
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
}
