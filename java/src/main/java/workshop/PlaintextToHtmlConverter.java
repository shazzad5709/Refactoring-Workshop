package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String filePath = "sample.txt";

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    protected String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(this.filePath)));
    }

    private String basicHtmlEncode(String source) {
        
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        
       for(int i=0;i < source.length();i++) {
        
            String characterToConvert = stashNextCharacterAndAdvanceThePointer(source,i);

            for(Character c : Character.values()){
                if(characterToConvert.equals(c.symbol)) {
                    convertedLine.add(c.output);
                } 
            }
            if(checkIfNotInEnum(characterToConvert) == false){
                convertedLine.add(characterToConvert);
            }
        }
        
        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


    private String stashNextCharacterAndAdvanceThePointer(String source,int pos) {
        char c = source.charAt(pos);
        return String.valueOf(c);
    }

    private void addANewLine(List<String> result,List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private boolean checkIfNotInEnum(String input){
       
        for(Character c : Character.values()){
            if(input.equals(c.symbol)){
                return true;
            }
        }

        return false;
    }
}