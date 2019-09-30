public class UI{
    public static void main(String args[]){
        //create and print list
        int listLength = 20;
        List<Integer> intList = new List<>();
        for(int i=0; i<listLength; i++){
            intList.appendNode(new Node<>((int)(Math.random()*100+1)));
        }
        System.out.println(intList.toString());

        //sort and print list
        intList.quickSort();
        System.out.println(intList.toString());
    }
}