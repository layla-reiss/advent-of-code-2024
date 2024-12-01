import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            ArrayList<String> input = readFile("DayOneMin.txt");
            ArrayList<String> splitInput = new ArrayList<>();
            String tempString;
            String[] current;
            for (int i = 0; i < input.size(); i++) {
                tempString = input.get(i);
                current = tempString.split("   ");
                splitInput.add(current[0]);
                splitInput.add(current[1]);
            }
            //every even index is the left number, every odd index is the right number
        return splitInput;
    }

    public static void main(String[] args) {
        ArrayList<String> input = dayOneFile();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        Integer temp;
        for (int i = 0; i < input.size(); i++)
        {
            temp = Integer.parseInt(input.get(i));
            if(i % 2 == 0) {
                oddNumbers.add(temp);
            } else {
                evenNumbers.add(temp);
            }
        }
        Collections.sort(oddNumbers);
        Collections.sort(evenNumbers);
        int total = 0;
        int distance;
        for (int i = 0; i < oddNumbers.size(); i++) {
            if(oddNumbers.get(i) > evenNumbers.get(i)) {
                distance = oddNumbers.get(i) - evenNumbers.get(i);
            } else {
                distance = evenNumbers.get(i) - oddNumbers.get(i);
            }
            total += distance;
        }
        System.out.println(total);
    }
}
