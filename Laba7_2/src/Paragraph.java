import java.util.Arrays;

public class Paragraph {
    public static String[] SplitIntoParagraphs(String text) {
        String[] sentences = text.trim().split("[\\n]+");
        return sentences;
    }

    public static void main(String[]args) {
        String text=MyFileReader.fileRead("file.txt");
        String[]paragraphs=SplitIntoParagraphs(text);
        for (int i=0;i<paragraphs.length;i++)
        {
            System.out.println((i+1)+" абзац: "+paragraphs[i]);
        }
    }
}
