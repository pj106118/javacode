public class NumberofDigital {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
       for(int i = 0 ;i<array.length;i++){
           if(k == array[i]){
               count ++;
           }
       }
        return count;
    }
}