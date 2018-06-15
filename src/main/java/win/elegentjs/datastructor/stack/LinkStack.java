package win.elegentjs.datastructor.stack;

import win.elegentjs.datastructor.link.Link;
import win.elegentjs.datastructor.link.LinkList;

public class LinkStack {

    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    public void push(String name) {
        linkList.insertFirst(name);

    }

    public Link pop() {
        return linkList.delFirst();
    }


    public Link peek() {
        return linkList.getFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }



    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();

        linkStack.push("a");
        linkStack.push("b");
        linkStack.push("c");
        linkStack.push("d");
        linkStack.push("e");
        linkStack.push("f");
        linkStack.push("g");
        linkStack.push("h");
        linkStack.push("i");


        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());



    }
}
