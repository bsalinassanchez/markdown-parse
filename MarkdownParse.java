// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MarkdownParse {
    //Updated method parameters from: String markdown -> String[] markdown
    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        //using a for loop instead of a while loop(different implementation of method)
        //loops through each line in a markdown file
        for(int i = 0; i < markdown.length; i++) {
            //checks that a line is not empty
            if(markdown[i].length() != 0) {
                int currentIndex = 0;
            while(markdown[i].substring(currentIndex).contains("[") && markdown[i].substring(currentIndex).contains("](") && markdown[i].substring(currentIndex).contains(")")) {
                //checks that a line contains brackets and parenthesis for links [...](...)
                //in the correct order
                //if(markdown[i].contains("[") && markdown[i].contains("](") && markdown[i].contains(")")) {
                    int indexOfOpenBracket = markdown[i].indexOf("[", currentIndex);
                    int indexOfMarker = markdown[i].indexOf("](", indexOfOpenBracket);
                    int closeParen = markdown[i].indexOf(")", indexOfMarker);
                    if(!markdown[i].substring(indexOfMarker+2, closeParen).isEmpty()) {
                        toReturn.add(markdown[i].substring(indexOfMarker+2, closeParen));
                    }
                    currentIndex = closeParen;
                //}
            }
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("no argument");
            return;
        } 
        String[] splitContents = Files.readAllLines(Paths.get(args[0])).toArray(String[]::new);

        ArrayList<String> links = getLinks(splitContents);
        System.out.println(links);
        System.out.println("all links have been returned");
    }
}