import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class DayOne {
    public static ArrayList<String> readFile(String filename) {
            ArrayList<String> splitFile = new ArrayList<>();
            try{
                File file = new File(filename);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    splitFile.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return splitFile;
        }
    
        public static ArrayList<String> dayOneFile() {
            ArrayList<String> input = readFile("DayOne.txt");
            ArrayList<String> splitInput = new ArrayList<>();
            String testString = input.get(0);
            String[] current = testString.split("   ");
            splitInput.add(current[0]);
            splitInput.add(current[1]);
            //every even index is the left number, every odd index is the right number
        return splitInput;
    }

    public static void main(String[] args) {
        ArrayList<String> input = dayOneFile();
        
    }
}
