package win.elegentjs.datastructor.link;

public class LinkList {

    private Link first;

    public void insertFirst(String name) {
        Link newLink = new Link(name);
        newLink.next = first;
        first = newLink;
    }

    public Link delFirst() {
        Link temp = first;

        if (temp != null) {
            first = first.next;
        }

        return temp;
    }

    public Link getFirst() {
        return first;
    }



    public void display() {
        Link current = first;

        while (current != null) {
            current.display();

            current = current.next;
        }
    }


    public boolean isEmpty() {
        return first == null;
    }


    public Link find(String key) {
        Link target = null;

        Link item = first;

        while (item != null) {
            if (key.equals(item.name)) {
                target = item;
                break;
            }

            item = item.next;

        }

        return target;
    }



    public Link del(String key) {
        Link target = null;
        Link previous = null;

        Link item = first;

        while (item != null) {
            if (key.equals(item.name)) {
                target = item;
                break;
            }

            previous = item;
            item = item.next;
        }

        if (target != null) {
            if (previous == null) {
                delFirst();
            } else {
                previous.next = item.next;
            }
        }

        return target;

    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.insertFirst("a");
        linkList.insertFirst("b");
        linkList.insertFirst("c");
        linkList.insertFirst("d");
        linkList.insertFirst("e");
        linkList.insertFirst("f");
        linkList.insertFirst("g");
        linkList.insertFirst("h");
        linkList.insertFirst("i");
        linkList.insertFirst("j");

        
        linkList.delFirst();

        linkList.display();

        System.out.println("============0===========");
        Link t = linkList.find("e");
        t.display();

        System.out.println("============1===========");

        linkList.del("i");
        linkList.display();

        System.out.println("============2===========");
        linkList.del("d");
        linkList.display();

        System.out.println("============3===========");
        linkList.del("a");
        linkList.display();



    }
}
