package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepImp implements JavaGrep{
    private String regex;
    private String rootPath;
    private String outFile;
    final Logger logger= LoggerFactory.getLogger(JavaGrepImp.class);

    public void process() throws IOException {
        List<String> matchedLines=new ArrayList<>();
        List<File> filesInDir=listFiles(getRootPath());
        for(File file:filesInDir){
            for(String line:readLines(file)){
                if(containsPattern(line)){
                    matchedLines.add(line);
                }
            }

        }
        writeToFile(matchedLines);


    }

    public List<File> listFiles(String rootDir) {
        List<File> fileNames=new ArrayList<>();
        File directoryPath = new File(rootDir);
        for (File file : directoryPath.list()) {
            fileNames.add(file);
        }

        return fileNames;

    }

    @Override
    public List<String> readLines(File inputfile) {
        List<String> allLines = null;
        try {
            FileInputStream fileStream = new FileInputStream(inputfile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
            String strLine;

            //Read File Line By Line
            while ((strLine = bufferedReader.readLine()) != null)   {
                allLines.add(strLine);
            }

          //Close the input stream
            fileStream.close();
        } catch (IOException e) {
            logger.error("File not found",e);
        }
        return allLines;
    }

    public boolean containsPattern(String line) {

        return line.matches(getRegex());
    }

    public void writeToFile(List<String> lines) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(getOutFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String line:lines){
                bufferedWriter.write(line+System.lineSeparator());
            }
            bufferedWriter.close();
        }

        catch (IOException e) {
            logger.error("File not found",e);
        }
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getOutFile() {
        return outFile;
    }

    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {
        if(args.length!=3){
            throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
        }
        JavaGrepImp javaGrepImp= new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);
        try{
            javaGrepImp.process();
        } catch (IOException e) {
            javaGrepImp.logger.error("Unable to process",e);
        }

    }
}
