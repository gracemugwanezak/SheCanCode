public class Matrix{
    public static void main(String [] args){
        int [][] A = {
                {1,2,3},
                {4,5,6}
        };

        int [][] B ={
                {7,8},
                {9,10},
                {11,12}
        };
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int [][]C = new int [rowsA][colsB];

        for(int i=0;i< rowsA;
        i++){
            for(int j=0;j<colsB;j++){
                C[i][j]=0;
                for(int k=0;k< colsA;k++){
                    C[i][j] +=A[i][k]*B[k][j];
                }
            }
        }
        System.out.println("Result matrix:");
        for(int i=0; i<C.length;i++ ){
            for(int j=0;j<C[0].length;j++){
                System.out.println(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}