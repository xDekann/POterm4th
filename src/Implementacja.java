import java.util.LinkedList;
class Stack<E>{
    private LinkedList<E> lista = new LinkedList<>();
    private int size = 0;
    public void add(E element){
        lista.addLast(element);
        size++;
    }
    public void remove(){
        try{
            lista.remove(size-1);
            size--;
        }catch(Exception e){
            System.out.println("Proba usuniecia wartosci z pustego stosu");
        }
    }
    public int getElementNumber(){
        return size;
    }
    public void peek(){
        try {
            if(size==0) throw new Exception();
            System.out.println("Ostatni element: " + lista.peekLast());
        }catch(Exception e){
            System.out.println("Pusty stos");
        }
    }
    @Override
    public String toString(){
        String wynik="";
        for(Object element:lista){
            wynik+=element+" ";
        }
        return wynik;
    }

}

public class Implementacja {
    public static void main(String[] args){
        Stack<Integer> stos = new Stack<>();
        /*
        stos.add("Adrian");
        stos.add("Kamil");
        stos.add("Zbigniew");
        stos.add("Dawid");
         */
        stos.add(1);
        stos.add(2);
        stos.add(3);
        stos.add(4);
        System.out.println(stos);
        stos.remove();
        System.out.println(stos);
        System.out.println(stos.getElementNumber());
        stos.peek();
        stos.remove();
        stos.remove();
        stos.remove();
        stos.remove();
        System.out.println(stos);
    }
}
