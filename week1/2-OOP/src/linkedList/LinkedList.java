package linkedList;


public class LinkedList implements LinkedListOperations {
    Node head;
    public LinkedList(){
        head=null;
    }
    public void insert(int d){
        if(head==null){
            head=new Node(d);
            return;
        }
        if(head.data>d){
            Node Holder=head;
            Node NewNode=new Node(d);
            head=NewNode;
            head.next=Holder;
            head.prev=NewNode;
            return;
        }
        Node tmpNode=head;
        while(tmpNode.next!=null && tmpNode.next.data<d){
            tmpNode=tmpNode.next;
        }
        Node prevTmp=tmpNode;
        Node insertedNode=new Node(d);
        if(tmpNode.next!=null){
            Node nextTmp=tmpNode.next;
            insertedNode.next=nextTmp;
            nextTmp.prev=insertedNode;
        }
        prevTmp.next=insertedNode;
        insertedNode.prev=prevTmp;
    }
    public void delete(int d){
        if(head==null){
            System.out.println("The list is empty!");
            return;
        }
        if(head.data==d){
            head=head.next;
            if(head!=null){
                head.prev=null;}
            return;
        }
        Node tmpNode=head;
        while(tmpNode!=null && tmpNode.data<d)
            tmpNode=tmpNode.next;
        if(tmpNode==null){
            System.out.println("That node does not exist!");
            return;
        }
        if(tmpNode.data==d){
            tmpNode.prev.next=tmpNode.next;
            if(tmpNode.next!=null){
                tmpNode.next.prev=tmpNode.prev;
            }
        }
    }
    public int size(){
        int s=0;
        Node tmpNode=head;
        while(tmpNode!=null)
        {tmpNode=tmpNode.next;s++;}
        return s;
    }
    public Node get(int elementIndex){
        Node tmpNode=head;
        int index=0;
        while(tmpNode!=null && index<elementIndex){
         index++;tmpNode=tmpNode.next;
        }
        return tmpNode;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        Node tmpNode=head;
        while(tmpNode.next!=null)
            tmpNode=tmpNode.next;
        return tmpNode;
    }
}
