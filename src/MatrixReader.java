import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixReader{
          SparseMatrix matrix;


    public SparseMatrix read(String file) {

        try {
          File matrixFile = new File(file);
          Scanner input = new Scanner(matrixFile);

          int rows = Integer.parseInt(input.nextLine());
          int columns = Integer.parseInt(input.nextLine());

          matrix = new SparseMatrix(rows, columns);

          int rowNum = 0;
          while(input.hasNextLine()) {
            String currentLineString = input.nextLine();
            String[] pairOfNum = currentLineString.split(" ");
            rowNum++;
            for(String x : pairOfNum) {
              String[] noComma = new String[2];
              noComma = x.split(",");
              int columnNum = Integer.parseInt(noComma[0]);
              int value = Integer.parseInt(noComma[1]);
              matrix.insert(rowNum, columnNum, value);
            }
          }
        }
        catch (FileNotFoundException e){
          System.out.println("File not found.");
        }
      return matrix;
    }
}

