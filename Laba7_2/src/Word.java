public class Word {
    public static String[] SplitIntoWords(String text) {
        String[] words = text.trim().split("[\\s]+");
        return words;
    }

    public static void main(String[]args) {
        String text=Main.cleaningFromSpacesAndTabulations(MyFileReader.fileRead("file.txt"));
        String[]words=SplitIntoWords(text);
        for (int i=0;i<words.length;i++)
        {
            System.out.println((i+1)+" слово: "+words[i]);
        }

    }
}
