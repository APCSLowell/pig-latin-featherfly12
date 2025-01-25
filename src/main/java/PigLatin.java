import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PigLatin {

    public void tester() {
        String[] lines = new String[8];
        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("there are " + lines.length + " lines");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }

    public int findFirstVowel(String sWord) {
        // precondition: sWord is a valid String of length greater than 0.
        // postcondition: returns the position of the first vowel in sWord. If there are no vowels, returns -1
        String vowels = "aeiou";
        for (int i = 0; i < sWord.length(); i++) {
            char c = sWord.charAt(i);
            if (vowels.indexOf(c) != -1) {
                return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        // precondition: sWord is a valid String of length greater than 0
        // postcondition: returns the pig latin equivalent of sWord
        int firstVowelIndex = findFirstVowel(sWord);

        if (firstVowelIndex == -1) {
            return sWord + "ay";
        }

        if (firstVowelIndex == 0) {
            return sWord + "way";
        }

        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        }

        return sWord.substring(firstVowelIndex) + sWord.substring(0, firstVowelIndex) + "ay";
    }
}
