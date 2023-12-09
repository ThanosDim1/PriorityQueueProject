public interface PQInterface {
    boolean isEmpty();
    int size();
    void insert(City x);
    City min();
    City getmin();
    City remove(int id);
    void resize();
    void sink(int id);
    void swim(int id);
    int  DEFAULT_CAPACITY = 4;
    int AUTOGROW_SIZE = 4;
}
