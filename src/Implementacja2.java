import java.util.Random;

class Pracownik implements Comparable<Pracownik>{
    private int idPrac;
    private static int counter=1;

    Pracownik(){
        idPrac=counter++;
    }

    @Override
    public int compareTo(Pracownik o) {
        return this.idPrac-o.idPrac;
    }
}
class Student implements Comparable<Student>{

    private int wiek;

    Student(){
        Random rand = new Random();
        this.wiek= rand.nextInt((25-18)+1)+18;
    }

    public int getWiek(){
        return this.wiek;
    }

    @Override
    public int compareTo(Student o) {
        return this.wiek-o.getWiek();
    }
}

class Set<T extends Comparable<T>>{
    private T[] set;
    private int pojemnosc;
    private int rozmiar;

    Set(int pojemnosc){
        this.pojemnosc = pojemnosc;
        this.rozmiar=0;
        set = (T[]) new Comparable[pojemnosc];
    }
    public void sort(T[] tab,int size){ //bubble sort
        T swapper;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (tab[j].compareTo(tab[j+1])>0) {
                    swapper = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = swapper;
                }
    }
    public void dodajElement(T element) throws Exception{
        int sprawdzenieCzyWZbiorze=0;
        if(rozmiar==pojemnosc) throw new Exception();
        for(int i=0;i<rozmiar;i++){
            if(set[i].equals(element)) sprawdzenieCzyWZbiorze=1;
        }
        if(sprawdzenieCzyWZbiorze==1){
            return;
        }
        if(rozmiar==0 && pojemnosc>0){
            this.set[rozmiar++]=element;
            return;
        }
        if(pojemnosc>0) {
            this.set[rozmiar++] = element;
            sort(set, rozmiar);
        }

    }
    public int szukaj(T element) throws Exception{
        for(int i=0;i<rozmiar;i++){
            if(set[i].equals(element)) return i;
        }
        throw new Exception();
    }
    /*
    public void display(){
        for(int i=0;i<rozmiar;i++){
            System.out.println(set[i]);
        }
    }
    */
    public String toString(){
        String wynik="";
        wynik="Pojemnosc: "+pojemnosc+"/"+"Rozmiar: "+rozmiar+"/"+"Elementy: ";
        for(int i=0;i<rozmiar;i++){
            wynik+=(set[i]+" ");
        }
        return wynik;
    }
    public void usunElement(T element){
        T swapper=set[rozmiar-1];
        for(int i=0;i<rozmiar;i++){
            if(set[i].equals(element) && i==rozmiar-1){
                rozmiar--;
                return;
            }
            if(set[i].equals(element)){
                set[i]= swapper;
                rozmiar--;
                sort(set,rozmiar);
                return;
            }
        }
    }

    public T[] getZbior(){
        return this.set;
    }
    public int getRozmiar(){
        return this.rozmiar;
    }
    public int getPojemnosc(){
        return this.pojemnosc;
    }
    public void dodajElementy(Set zbior) throws Exception{
        T[] set2 = (T[]) zbior.getZbior();
        if(this.rozmiar+zbior.getRozmiar()>=this.pojemnosc) throw new Exception("Laczny rozmiar zbiorow jest wiekszy od pojemnosci pierwotnego");
        for(int i=0;i<zbior.getRozmiar();i++){
            this.dodajElement(set2[i]);
        }
    }

    public void odejmijElementy(Set zbior){
        T[] set2 = (T[]) zbior.getZbior();
        for(int i=0;i<zbior.getRozmiar();i++) {
            this.usunElement(set2[i]);
        }
    }

    public T[] przeciecie(Set zbior){
        T[] set2 = (T[]) zbior.getZbior();
        int pojemnoscWspolna=0;
        if(this.pojemnosc<zbior.getPojemnosc()) pojemnoscWspolna = this.pojemnosc; //wybierana mniejsza pojemnosc;
        else pojemnoscWspolna = zbior.getPojemnosc();
        int counter=0;
        T[] set3 = (T[]) new Comparable[pojemnoscWspolna];
        for(int i=0;i<this.rozmiar;i++){
            for(int j=0;j<zbior.getRozmiar();j++){
                if(set[i].equals(set2[j])) set3[counter++] = set[i];
            }
        }
        return set3;
    }

}
public class Implementacja2 {
    public static void main(String[] args){
        Set<Student> test = new Set<>(5);
        Set<Student> testPrzeciecie = new Set<>(5);
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        System.out.println("Student1 adres/wiek -> "+student1+" "+student1.getWiek());
        System.out.println("Student2 adres/wiek -> "+student2+" "+student2.getWiek());
        System.out.println("Student3 adres/wiek -> "+student3+" "+student3.getWiek());
        try{
            test.dodajElement(student1);
            test.dodajElement(student2);
            test.dodajElement(student3);
            test.dodajElement(student2);
            testPrzeciecie.dodajElement(student1);
            testPrzeciecie.dodajElement(student2);
            System.out.println("Student2 na pozycji: "+test.szukaj(student2));
        }catch(Exception e){
            System.out.println("Wyjscie poza limit");
        }
        //test.display();
        test.usunElement(student2);
        System.out.println(test);
        /***************/
        Pracownik pracownik1 = new Pracownik();
        Pracownik pracownik2 = new Pracownik();
        Pracownik pracownik3 = new Pracownik();
        Pracownik pracownik4 = new Pracownik();
        Set<Pracownik> test2 = new Set<>(10);
        Set<Pracownik> test3 = new Set<>(10);
        try{
            test2.dodajElement(pracownik1);
            test2.dodajElement(pracownik2);
            test3.dodajElement(pracownik3);
            test3.dodajElement(pracownik4);
            test2.dodajElementy(test3);
            System.out.println(test2);
            test2.odejmijElementy(test3);
            System.out.println(test2);

        }catch(Exception e){
            System.out.println("Wyjscie poza limit");
        }

        Comparable[] check;
        check =  testPrzeciecie.przeciecie(test);
        if(check[0].equals(student1)) System.out.println("True");

    }
}
