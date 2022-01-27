// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        //int currentIndex = 0;
        //while(currentIndex < markdown.length()) {
        //    int nextOpenBracket = markdown.indexOf("[", currentIndex);
        //    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
        //    int openParen = markdown.indexOf("(", nextCloseBracket);
        //    int closeParen = markdown.indexOf(")", openParen);
        //    toReturn.add(markdown.substring(openParen + 1, closeParen));
        //    currentIndex = closeParen + 1;
        //    System.out.println("current index: " + currentIndex);
        //}

        //using a for loop instead of a while loop
        for(int i = 0; i < markdown.length; i++) {
            if(markdown[i].length() != 0) {
                if(markdown[i].contains("](")) {
                    int indexOfMarker = markdown[i].indexOf("](");
                    int closeParen = markdown[i].indexOf(")", indexOfMarker);
                    toReturn.add(markdown[i].substring(indexOfMarker+2, closeParen));
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
		//Path fileName = Path.of(args[0]);
	    //String contents = Files.readString(fileName);
        //split contents into string array
        String[] splitContents = Files.readAllLines(Paths.get(args[0])).toArray(String[]::new);

        //System.out.println(contents);

        ArrayList<String> links = getLinks(splitContents);
        System.out.println(links);
        System.out.println("all links have been returned");
    }
}