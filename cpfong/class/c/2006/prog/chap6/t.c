#include "stdio.h"

main(){
	int c='5';

	// isalnum ���զr�ŬO�_���^��μƦr, ������Ʀ� isalpha isdigit islower isupper
	if (isdigit(c)) {
		printf("%c is digit\n", c);
	}
	else {
		printf("%c is NOT digit\n", c);
	}
}
