int top;
int stack[10];

main(){
	int i, t;

/* �����ݳo��
	for (i=0; i<10; i++){
		push(i); 
	}
*/
	// ��J�r�� a, b, c �T�Ӧr��
	push('a'); push('b'); push('c');

	// ���X�G�Ӧr��
	pop();
	t = pop();
	printf("pop out %c \n", t);
}

push(int t){
	stack[top]=t;
	printf("push %d into stack[%d]\n", t, top);
	top++;
}

pop(){
	int t;

	top--;
	t = stack[top];
	return (t);
}
