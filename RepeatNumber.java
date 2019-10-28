import java.util.*;
public class RepeatNumber {
	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0 || numbers.length == 0){
             return false;
        }
        Set<Integer> set = new TreeSet<>();
        for(int i = 0;i < length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                 return true;
            }else{
                set.add(numbers[i]);
            }
            
        }
        return false;
    }
}
