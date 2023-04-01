package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp{
    public static void main(String[] args) {
        if(args.length!=3){
            throw new IllegalArgumentException("Usage: JavaGrepLambda regex rootPath outFile");
        }
        JavaGrepLambdaImp javaGrepImp= new JavaGrepLambdaImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);
        try{
            javaGrepImp.process();
        } catch (IOException e) {
            javaGrepImp.logger.error("Unable to process",e);
        }

    }

    @Override
    public List<String> readLines(File inputfile) {
        List<String> lines=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(inputfile)))) {
            lines=stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> files = new ArrayList<>();
        try {
            files = Files.list(Paths.get(rootDir))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}
