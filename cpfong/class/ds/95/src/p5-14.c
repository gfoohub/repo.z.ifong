#define	NULL	0

struct node {
	char data;
	struct node *link;
};

// �ͦ��@�ӷs���`�I
struct node * new(){
	struct node *p;

	p = (struct node *)malloc(sizeof(struct node));
	return p;
} // end new

// �D�{��
main(){
	struct node *list;
	struct node *p, *q, *c;
	
	p=new(); p->data='f'; list=p;
	q=new(); q->data='t';
	
	p->link=q;
	q->link=NULL;

	c=list;
	while (c->link){
		printf("%c\n", c->data);
		c=c->link;
	}
	// last one
	printf("%c\n", c->data);
} // end main
