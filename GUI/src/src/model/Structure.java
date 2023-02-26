package model;

public class Structure {
    int id;
    int userId;
    int jobId;
    int parent;
    int child;

    public Structure() {
    }

    public Structure(int id, int parent, int child) {
        this.id = id;
        this.parent = parent;
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }
}
