public class main {

    public static void main(String[] args) {

        LinkedListOfInteger lista = new LinkedListOfInteger();

        for (Integer i = 1; i < 60; i = i + 10) {

            lista.add(i);

        }

        System.out.println(lista.toString());

        // System.out.println(lista.toString());

        // System.out.println(lista.get(4));

        // System.out.println(lista.size());

        // System.out.println(lista.IndexOf(1));

        // lista.remove(10);

        // System.out.println(lista.toString());

        //lista.set(5, 333);

        //lista.add(200);

        //System.out.println(lista.toString());

       

        System.out.println(lista.removeByIndex(5));

        System.out.println(lista.toString());

    }

}
