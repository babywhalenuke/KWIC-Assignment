import java.util.LinkedList;

public class Line {
    LinkedList<Object> list;

    public void add(Object o){
        list.add(o);
    }

    public void circularShift(int numShifts){
        for(int i = 0 ; i < numShifts; i++){
            list.addLast(list.removeFirst());
        }
    }
}
