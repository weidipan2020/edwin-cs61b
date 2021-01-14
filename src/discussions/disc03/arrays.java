package discussions.disc03;

public class arrays {

	/*
	2.1 Consider a method that inserts an int item into an int[] arr at the given position.
The method should return the resulting array.
	TODO: Is it possible to write a version of this method that returns void and changes arr in place
	 (i.e., destructively)?
	 Hint: These arrays are filled meaning an array containing n elements will have length n.
    */

    public static int[] insert(int[] arr, int item, int position) {
		int n = arr.length;
        int[] newArray = new int[n + 1];
        System.arraycopy(arr, 0, newArray, 0, position);
        for (int i = n - 1; i >= position; i--) {
        	newArray[i+1] = arr[i];
        }
        newArray[position] = item;
        return newArray;
	}

	/*
	2.2 Consider a method that destructively reverses the items in arr.
	*/
	public static void reverse(int[] arr) {
		int front = 0;
		int back = arr.length - 1;
		int tmp = 0;
		while (front < back) {
			tmp = arr[front];
			arr[front] = arr[back];
			arr[back] = tmp;
			front++;
			back--;
		}
	}


	/*
	2.3 Extra: Write a non-destructive method replicate(int[] arr) that replaces the
number at index i with arr[i] copies of itself.
	*/
	public static int[] replicate(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		int[] newArray = new int[sum];

		int curPosition = 0;
		for (int i : arr) {
			for (int j = 0; j < i; j++) {
				newArray[curPosition] = i;
				curPosition++;
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		int[] arr = {5, 9, 14, 15};
		int[] arr1 = arrays.insert(arr, 6, 2);
        arrayPrint(arr1);


		arr = new int[] {1, 2, 3};
		arrays.reverse(arr);
        arrayPrint(arr);

		arr = new int[] {3, 2, 1};
		int[] arr3 = arrays.replicate(arr);
        arrayPrint(arr3);
	}


	public static void arrayPrint(int[] arr) {
	    for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
