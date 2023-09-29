import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                if (line.trim().equals("")) {
                    continue;
                }
                String result = processLine(line);
                System.out.print(result);
                if (scan.hasNext()) {
                    System.out.println(); // print newline if there are more lines to process
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    /**
     * Takes in a string, computes arithmetic, then formats the output and returns it as a string.
     * @param str
     * @return
     */
    private static String processLine(String str) {
        // Parse operands and operator
        String[] tokens = str.trim().split("\\s+");
        LinkedList num1 = new LinkedList(tokens[0]);
        LinkedList num2 = new LinkedList(tokens[2]);
        String op = tokens[1];

        // Compute arithmetic
        LinkedList result;
        switch(op) {
            case "+":
                result = num1.add(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "^":
                result = num1.exponentiate(num2);
                break;
            default:
                return ("Invalid operator: " + op);
        }

        // Format output and return
        return (num1 + " " + op + " " + num2 + " = " + result);

    }
}
