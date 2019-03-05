public class arrayMaxElement{
	
	public static void main(String[] args){
		
		int[] array = new int[]{2,1,61,33,58};
		
		java.util.Arrays.sort(array);
		
		int max = array[array.length - 1];
		
		System.out.println(max);
		
	}
	
}