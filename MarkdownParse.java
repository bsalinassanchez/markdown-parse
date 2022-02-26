// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int imageIndex = markdown.indexOf("!", currentIndex);
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("](", nextOpenBracket);
            //int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", nextCloseBracket);


            int firstBacktick = markdown.indexOf("`", currentIndex);
            int secondBacktick = -1;
            Boolean between = false;
            if(firstBacktick != -1) {
                secondBacktick = markdown.indexOf("`", firstBacktick);
            }

            if(firstBacktick != -1 && secondBacktick != -1) {
                if(currentIndex >= firstBacktick && currentIndex <= secondBacktick) {
                    between = true;
                }
            }
            
            if (nextOpenBracket == -1 || nextCloseBracket == -1 /*|| openParen == -1 */|| closeParen == -1)
            {
                break;
            }

            if (imageIndex > -1 && imageIndex == nextOpenBracket - 1 || between == true)
            {
                currentIndex = closeParen + 1;
            }
            else
            {
                
                toReturn.add(markdown.substring(nextCloseBracket + 2, closeParen));
                currentIndex = closeParen + 1;
                
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 0)
        {
            Path fileName = Path.of(args[0]);
            String contents = Files.readString(fileName);
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
        }
    }
}