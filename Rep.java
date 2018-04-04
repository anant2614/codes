
public class Rep {

	public static void main(String arg[]){
		int n = 0;
		int a[] =  {1, 2, 3, 1, 3, 6, 6};
		for(int i=0;i<a.length;i++){
			int x = 1<<(a[i]-1);
			if((n&x)!=0){
				System.out.println(a[i]);
			}
			else{
				n=n|x;
			}
		}
	}
}
