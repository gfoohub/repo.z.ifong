#define SIZE 5		// ���|���j�p
int stack[SIZE];	// �ŧi�@�}�C�j�p�� 5 �i�H�� 5 �Ӿ��
int top=0;		// ���|�̤W���� (���e����)

// �D�{���}�l
main(){

	int t;
	int i=1;

	// ����J���ӼƦܰ��|, ���O�� 1 2 3 4 5 6 
	for (i=1; i <= 6; i++){
		push(i);
	}

	// �s�� pop �T���H���X�T�Ӽ�, �B�L�X��
	for (i=1; i <= 3; i++){
		t= pop(); printf(" %d \n", t);
	}

	push(7); // ��J 7

	for (i=1; i <= 6; i++){
		t= pop();
		if (t != -1){
			printf(" %d \n", t);
		}
	}


} // �D�{������

// push �Ƶ{��, �Ψӧ⤺�e���J���|��
push(int t){

	if (top == SIZE) {
		// �ڤ���A�ˤF, �]���w���F
		printf("%d �񤣤U�]�����F \n", t);
	}
	else {
		// �|���Ŧ�
		stack[top] = t;
		top++;
	}

} // end push

// ���X���Ƶ{��, �Ψӧ⤺�e���X
int pop(void){
	int t;

	if (top == 0) {
		// ���|���e�w��
		printf(" �ŤF \n");
		return(-1);
	}
	else {
		return stack[--top];
	}

} // end pop
