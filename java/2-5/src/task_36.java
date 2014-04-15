
public class task_36 {
	
     //3.1 Разместить в памяти массив из 20 элементов и заполнить его рядом чисел Фиббоначчи.     
    public static int[] fib() {
        int[] array = new int[20];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array;
    }

    
    //3.2 Создать массив из 100 элементов и заполнить его простыми числами.    
    public static int[] arrayOfPrimes() {
        int[] array = new int[100];
        int arrayPos = 0;
        int number = 2;
        while (true) {
            if (task_25.isPrime(number)) {
                array[arrayPos] = number;
                arrayPos++;
                if (arrayPos == 100) {
                    break;
                }
            }
            number++;
        }
        return array;
    }

    
    //2.3 Создать двумерный массив символов и заполнить его буквами Ч и Б в шахматном порядке.    
    public static int[][] chessArray() {
        int[][] array = new int[8][8];
        for (int i = 0; i < array.length; i++) {
            int[] sub = array[i];
            for (int j = 0; j < sub.length; j++) {
                if ((i + j) % 2 == 0) {
                    array[i][j] = 1;
                }
            }
        }
        // prettify
        for (int i = 0; i < array.length; i++) {
            int[] is = array[i];
            for (int j = 0; j < is.length; j++) {
                int k = is[j];
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    //2.4 Создать целый шестимерный массив с двумя значениями в каждом измерении.
    //Заполнить массив из начала натурального ряда 1, 2, 3 ...сколько потребуется чисел? 2^6 = 64
    public static int multiArray() {
        int result = 0;
        int[][][][][][] a6 = new int[2][2][2][2][2][2];


        for (int i = 0; i < a6.length; i++) {
            int[][][][][] a5 = a6[i];
            for (int j = 0; j < a5.length; j++) {
                int[][][][] a4 = a5[j];
                for (int k = 0; k < a4.length; k++) {
                    int[][][] a3 = a4[k];
                    for (int l = 0; l < a3.length; l++) {
                        int[][] a2 = a3[l];
                        for (int m = 0; m < a2.length; m++) {
                            int[] a1 = a2[m];
                            for (int n = 0; n < a1.length; n++) {
                                a1[n] = result;
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    
    //2.5 Создать треугольный массив из 10 строк и заполнить его биномиальными коэфициентами (треугольник Паскаля)    
    public static void pascalTriangle() {

        int[][] array = new int[10][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i+1];
            array[i][0] = 1;
            array[i][i] = 1;
            if(array[i].length < 3) {
                continue;
            }
            for(int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
            }
        }
        for (int i = 0; i < array.length; i++) {
            int[] is = array[i];
            for (int j = 0; j < (10-i)/2; j++) {
                System.out.print("    ");
            }
            if (i % 2 == 1) {
                System.out.print("  ");
            }
            for (int j = 0; j < is.length; j++) {
                System.out.format("%-4d", is[j]);
            }
            System.out.println();
        }
    }
}
