/*
	��Y�@�r�ꤤ�X�{�t�@�r�ꪺ�a��H index �覡�Ǧ^
	s = "abcd" t="c" �h�Ǧ^ 2
	���X�{�h�Ǧ^ -1
*/
int strindex(char s[], char t[]){
	int i,j,k;
	
	for (i=0; s[i]!='\0'; i++){
		for (j=i, k=0; t[k] != '\0' && s[j] == t[k]; j++, k++);
		if (k>0 && t[k]=='\0')
			return i;
	}
	return -1;
}	
