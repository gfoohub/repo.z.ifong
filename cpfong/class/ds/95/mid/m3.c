#define N 80
char stack[N];
int top=-1;
char infix[N];;
char postfix[N];

void push(char d){
	if(top==N-1){
		printf("���|���F\n");
		exit(1);
	}
	stack[++top]=d;
}

char pop(){
	if(top==-1){
		printf("���|�ŤF\n");
		exit(1);
	}
	return(stack [top--]);
}

int p(char d){
	if(d=='*' || d=='/')
		return(2);
	else if(d=='+' || d=='-')
		return(1);
	else
		return(0);
}

void infix_to_postfix(){
	char token;
	int i=0,j=0;

	while((token=infix[i++])!='\0'){
		switch(token){
			case '(':push (token);
				break;
			case ')':while (stack [top]!='(')
					postfix[j++]=pop();
				pop();
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				while ((top!=-1)&&(p(stack [top])>=p(token)))
					postfix [j++]=pop();
				push (token);
				break;
			default:postfix [j++]=token;
		}
	}
	while (top!=-1)
		postfix [j++]=pop();
}

main(){
	printf("��J���ǥ|�h�B�⦡�G");
	scanf("%s",infix);
	infix_to_postfix();
	printf("�h��ǥ|�h�B�⦡��:%s\n",postfix);
}

