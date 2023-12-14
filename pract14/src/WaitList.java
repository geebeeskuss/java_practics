import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList <E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;
    public WaitList(){
        content = new ConcurrentLinkedQueue<>();
    }
    public WaitList(Collection<E> c){
        content = new ConcurrentLinkedQueue<>(c);
    }
    @Override
    public String toString() {
        return "WaitList( content= " + content + ")";
    }
    @Override
    public void Add(E element) {
        content.add(element);
    }
    @Override
    public E Remove() {
        if(isEmpty()) System.out.println("Элементов нет!");
        return content.remove();
    }
    @Override
    public boolean contains(E element) {
        boolean res = false;
        for(int i = 0; i < content.size(); i++){
            E locelem = content.remove();
            if(locelem.equals(element)) res = true;
            content.add(locelem);
        }
        return res;
    }
    @Override
    public boolean containsAll(Collection<E> c) {
        ArrayList<E> all = new ArrayList<>(c);
        for(int i = 0; i < c.size(); i++){
            boolean res = false;
            for(int j = 0; j < content.size(); j++){
                E locelem = content.remove();
                if(locelem.equals(all.get(i))) res = true;
                content.add(locelem);
            }
            if(!res) return false;
        }
        return true;
    }
    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
