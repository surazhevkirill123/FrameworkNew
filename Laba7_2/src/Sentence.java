import java.util.Arrays;

public class Sentence {
    public static String[] SplitIntoSentences(String text) {
        String[] sentences = text.trim().split("[\\n.!?]+");
        return sentences;
    }

    public static void main(String[]args) {
        String text=Main.cleaningFromSpacesAndTabulations(MyFileReader.fileRead("file.txt"));
        String[]sentences=SplitIntoSentences(text);
        for (int i=0;i<sentences.length;i++)
        {
            System.out.println((i+1)+" предложение: "+sentences[i]);
        }

    }
}