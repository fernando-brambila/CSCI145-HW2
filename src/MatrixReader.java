import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class MatrixReader{
          SparseMatrix matrix;
    public SparseMatrix read(String file) {

        try {
          File matrixFile = new File(file);
          Scanner input = new Scanner(matrixFile);

          int rows = Integer.parseInt(input.nextLine());
          int columns = Integer.parseInt(input.nextLine());

          matrix = new SparseMatrix(rows, columns);

          String[] x = new String[0];
          String[] temp = new String[columns];
          String d = "";
          int rowNum = 0;
          while(input.hasNextLine()) {
              rowNum++;
              d = input.nextLine();
              temp = d.split(" ");
              x = combine(x, temp);
          }
          System.out.println(Arrays.toString(x));

          String[] noComma;
          for(String a : x) {
            noComma = a.split(" ")
            int columnNum = Integer.parseInt(noComma[0]);
            int value = Integer.parseInt(noComma[1]);
            System.out.println(Arrays.toString(noComma));
            matrix.insert(1, columnNum, value);
          }
        }

        catch (FileNotFoundException e){
          System.out.println("File not found.");
        }
      return matrix;
    }

    public String[] combine(String[] a, String[] b) {
      int length = a.length+b.length;
      String[] result = new String[length];
      System.arraycopy(a, 0, result, 0, a.length);
      System.arraycopy(b, 0, result, a.length, b.length);
      return result;
    }
}
