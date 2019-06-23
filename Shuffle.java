import java.util.Scanner; 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int groups = sc.nextInt();//数组组数
		while (groups-- > 0){
			int n = sc.nextInt();
			//数字个数的一半
			int k = sc.nextInt();
			//洗牌次数
			int[] res = new int[2*n];
			//数据总个数
			for(int i=0;i<2*n;i++){
				//遍历数据数组
				in mp = i + 1;
				//此处修正内层循环更加temp计算位置
				for(int j = 0; j < k;j++){
					if (tmp<= n){ tmp = 2*tmp - 1;
				}else{
					tmp = 2 * (tmp - n); 
				}
			}
			res[tmp - 1]=sc.nextInt();
			//数组中temp-1的位置的数据，即就是洗牌后的结果 
		}
		//输出
		if(res.length> 0){
			System.out.print(res[0]);
		}
		for(int i = 1;i< 2*n;i++){
			System.out.print(" "+res[i]); 
		}
		System.out.println();
		}
	}
}