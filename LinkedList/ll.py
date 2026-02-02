# head={"num":10,
#       "next":{"num":10,
#               "next":{"num":10,
#                       "next":{"num":400,
#                               "next":None
#                                             }
#                                                     }
#                                                             }
#                                                                      }
# print(head["next"]["next"]["next"]["num"])
class Node:
    def __init__(self,value):
        self.value=value
        self.next=None
class LinkedList:
    def __init__(self,value):
        new_node=Node(value)
        self.head=new_node
        self.tail=new_node
        self.length=1
    def printlist(self):
        temp=self.head
        while temp is not None:
            print(temp.value)
            temp=temp.next
    def append_node(self,value):
        new_node = Node(value)
        if self.head == None:
            self.head=new_node
            self.tail=new_node
        else:
            self.tail.next=new_node
            self.tail=new_node
        self.length+=1
        return True
    def pop(self):

        # removes the last element
        if self.length == 0:
            return None
        else:
            temp=self.head
            pre=self.head
            while(temp.next):
                pre=temp
                temp=temp.next
            self.tail=pre
            self.tail.next=None
            self.length-=1
            if self.length ==0:
                self.head=None
                self.tail=None
        return True
    def prepend(self,value):
        new_node=Node(value)
        if self.length==0:
            self.head=new_node
            self.tail=new_node
        else:
            temp=self.head
            self.head=new_node
            self.head.next=temp
        self.length += 1
        return True
    def pop_first(self):
        if self.length==0:
            print("there is an empty list")
            self.head=None
            self.tail=None
        else:
            temp=self.head
            self.head=self.head.next
            temp.next=None
            self.length-=1
            if self.length==0:
                self.tail=None
    def get(self,index):
        if index<0 or self.length<index:
            return None
        else:
            temp=self.head
            for _ in range(index):
                temp=temp.next
            return temp
    def set_value(self,index,value):

        temp=self.get(index)
        if temp:
            temp.value=value
            return True
        return False
    def insert_value(self,index,value):
        temp=self.get(index-1)
        new_node=Node(value)
        if index==0:
            self.prepend(value)
        if self.length-1 == index:
            self.append_node(value)
        if temp:
            new_node.next=temp.next
            temp.next=new_node
            self.length+=1
        return True

    def remove_element(self,index):
        prev=self.get(index-1)
        if index==0:
            return self.pop_first()
        if index==self.length-1:
            return self.pop()
        if prev:
            temp=prev.next
            prev.next=temp.next
            temp.next=None
            self.length-=1
            return temp


    def revese_list(self):
        temp=self.head
        self.head=self.tail
        self.tail=temp
        before=None
        after=temp.next
        for _ in range(self.length):
            after=temp.next
            temp.next=before
            before = temp
            temp=after






my_linked_list=LinkedList(4)
my_linked_list.append_node(5)
my_linked_list.append_node(6)
my_linked_list.prepend(3)
my_linked_list.insert_value(2,2)
my_linked_list.remove_element(2)
my_linked_list.printlist()

