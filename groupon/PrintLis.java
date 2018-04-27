package groupon;

import java.util.Stack;

public class PrintLis {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = new int[]{ 10, 22, 9, 33, 21, 50, 41, 60 , 80};
		int arr[] = {3, 2, 6, 4, 5, 1};
		int lis[] = new int[arr.length];
		storeLis(arr, lis);
 
		int maxIndex = findMaxLisIndex(lis);
		Stack<Integer> stack = new Stack<Integer>();
		int lastMaxIndex = maxIndex;
		stack.push(arr[lastMaxIndex]);
		for ( int j = maxIndex -1 ; j >= 0 ; j--)		{
			if ( lis[lastMaxIndex] == lis[j] + 1 && arr[lastMaxIndex] > arr[j])		{
				stack.push(arr[j]);
				lastMaxIndex = j;
			}
		}
 
		printLis( stack);
	}
 
	private static void printLis(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		while( !stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
 
	private static int findMaxLisIndex(int[] lis) {
		// TODO Auto-generated method stub
		int maxIndex = 0;
		for ( int i = 1 ; i < lis.length ; i++)	{
			if ( lis[i] > lis[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
 
	}
 
	private static void storeLis(int[] arr, int[] lis) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < arr.length ; i++)
			lis[i] = 1;
		for ( int i = 1 ; i < arr.length ; i++)	{
			for ( int j = 0 ; j < i ; j++)	{
				if ( arr[j] < arr[i] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
	}
 
}
