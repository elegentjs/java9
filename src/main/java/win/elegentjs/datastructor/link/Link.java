package win.elegentjs.datastructor.link;

public class Link {
    public String name;
    public Link next;

    public Link(String name) {
        this.name = name;
    }


    public void display() {
        System.out.println("name : " + name);
    }


    @Override
    public String toString() {
        return name;
    }
}
