package HEAP;

public class HeightOfHeap {
    public static void heihgt(int[]arr){
        if(arr.length==1){
            System.out.println(1);
            return;
        }int h=0;
        int n=arr.length;
        while (n>1) {
            h++;
            n/=2;
        }System.out.println(h);
    }public static void main(String[] args) {
        int[]arr={1,3,6,5,9,8};
        heihgt(arr);
    }
}
