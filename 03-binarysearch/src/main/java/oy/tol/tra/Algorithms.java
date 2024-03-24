package oy.tol.tra;

public class Algorithms {

private Algorithms(){

}

    public static int binarySearch(int target, Integer[] array, int from, int to) {

    int Jin= from;
    int Chu= to;

        while (Jin <= Chu) {
            int middle=(Chu+Jin)/2;
                if (array[middle]== target) {
                    return middle;
                } else if (array[middle]<target) {
                    Jin=middle+1;
                }else {
                    Chu=middle-1;
                }
        }
        return -1;
    }


    public static int binarySearch(String value, String[] array, int from, int to) {

        int Jin1= from;
        int Chu1= to;

        while (Jin1 <= Chu1) {
            int Zhong=(Chu1+Jin1)/2;
            int cap=value.compareTo(array[Zhong]);

            if (cap== 0) {
                return Zhong;
            } else if (cap<0) {
                Chu1=Zhong+1;
            }else {
                Jin1=Zhong-1;
            }
        }
        return -1;
    }


    public static  void sort(Integer[] array) {

        int n = array.length;

        for (int i=0;i<n-1;i++) {
            for(int j=0;j<n-1-i;j++){
                if (array[j]>array[j+1]){
                    int number=array[j];
                    array[j]=array[j+1];
                    array[j+1]=number;
                }
            }
        }

    }

    public static void quickSort(String[] array,int start,int end){
    if (start<end){
        int Data1= partition(array,start,end);
        quickSort(array,start,Data1-1);
        quickSort(array,Data1+1,end);
    }
    }

    public static void sort(String[] array){
    quickSort(array,0,array.length-1);
}

    public static int partition(String[] array,int start,int end){
    String pivot =array[end];
    int i=start-1;
    for(int j=start; j<end; j++){
        if (array[j].compareTo(pivot)<0){
            i++;
            String nonumber=array[i];
            array[i]=array[j];
            array[j]=nonumber;
        }
    }
    String tap=array[i+1];
    array[i+1]=array[end];
    array[end]=tap;
    return i+1;
    }


}
