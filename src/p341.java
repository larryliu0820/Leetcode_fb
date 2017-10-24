import java.util.Iterator;
import java.util.List;

/**
 * Created by Larry Liu on 10/23/2017.
 * 341. Flatten Nested List Iterator
 */
public class p341 implements Iterator<Integer> {
    private int index;
    private p341 currIterator;
    private List<NestedInteger> list;
    public p341(List<NestedInteger> nestedList) {
        index = 0;
        list = nestedList;
    }

    @Override
    public Integer next() {
        if (index >= list.size()) return null;
        if (list.get(index).isInteger()) {
            currIterator = null;
            return list.get(index++).getInteger();
        }
        if (currIterator == null) {
            currIterator = new p341(list.get(index).getList());
        }
        if (!currIterator.hasNext()) {
            currIterator = null;
            index++;
            return next();
        } else return currIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (index >= list.size()) return false;
        if (list.get(index).isInteger()) {
            currIterator = null;
            return true;
        }
        if (currIterator == null) {
            currIterator = new p341(list.get(index).getList());
        }
        if (!currIterator.hasNext()) {
            currIterator = null;
            index++;
            return hasNext();
        } else return true;
    }
}
