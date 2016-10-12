import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by siddharthvarshney on 10/9/16.
 */
public class Test {
    public static void main(String args[]) {

        LinkedList<Integer> lista = new LinkedList<>();
        lista.push(1);
        lista.push(2);
        //lista.push(3);
        lista.push(4);
        lista.push(5);
        ListIterator<Integer> it = lista.listIterator();
        int count = 0;
        while(it.hasNext())
        {
            count++;
            System.out.println(it.next());
        }
        System.out.print(lista.size());
    }
}