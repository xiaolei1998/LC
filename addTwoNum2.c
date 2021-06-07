struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){

    int carry = 0;
    int a= 0;
    int b= 0;
    int digits = 0;

    short l1End = 0;
    short l2End = 0;

    struct ListNode * result = (struct ListNode * )malloc(sizeof(struct ListNode));
    struct ListNode * ptr = result;

    while(true){

        if(l1End == 1){
            a = 0;
        }else{
            a = l1->val;
        }

        if(l2End == 1){
            b = 0;
        }else{
            b = l2->val;
        }
        

        digits = a+b+carry;


        if(digits>=10){
            carry = 1;
            digits = digits%10;
        }else{
            carry = 0;
        }


        if(l1->next != NULL){
            l1 = l1->next;
        }else{
            l1End = 1;
        }

        if(l2->next != NULL){
            l2 = l2->next;      
        }else{
            l2End = 1;
        }


        struct ListNode * new = (struct ListNode *)malloc(sizeof(struct ListNode));
        new->next = NULL;
        ptr->val = digits;  
        ptr->next = NULL;
        

        if(l1End==1 && l2End==1){
            if(carry != 0){
                new->val = 1;
                ptr->next = new;
                ptr = ptr->next;
            }
            break;

        }else{
            ptr->next = new;
            ptr = ptr->next;
        }

    }

    return result;
}
