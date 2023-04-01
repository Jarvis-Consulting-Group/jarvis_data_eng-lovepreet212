package ca.jrvs.practice.codingChallenge;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.Connection;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements LambdaStreamExc{
    Logger logger= LoggerFactory.getLogger(LambdaStreamExcImp.class);
    @Override
    public Stream<String> createStrStream(String... strings) {
        Stream<String> stream = Arrays.stream(strings);
        return stream;
    }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        Stream<String> stringStream = createStrStream(strings);
        return stringStream.map(String::toUpperCase);
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return stringStream.filter(s -> !s.contains(pattern));

    }

    @Override
    public IntStream createIntStream(int[] arr) {
        IntStream stream = Arrays.stream(arr);
        return stream;
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        List<E> list = stream.collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        List<Integer> integerList=intStream.boxed().collect(Collectors.toList());
        return integerList;
    }

    @Override
    public IntStream createIntStream(int start, int end) {
        return IntStream.rangeClosed(start,end);
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {

        return intStream.mapToDouble(num -> num*num);

    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        return intStream.filter(n-> n%2!=0);
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return i-> System.out.print(prefix+i+suffix+"\n");
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {
        for(String s:messages){
            printer.accept(s);
        }
    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {
        IntStream oddStream=getOdd(intStream);
        oddStream.forEach(i->printer.accept(String.valueOf(i)));
    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {

        return ints.flatMap(n-> {return n.stream().map(m->m*m);});

    }

    public static void main(String[] args) {

        String[] array1= new String[args.length];
        for(int i=0;i< args.length;i++){
            array1[i]=args[i];

        }
        LambdaStreamExc lambdaStreamExc=new LambdaStreamExcImp();
        Stream<String> toUpperCaseStream=lambdaStreamExc.toUpperCase(array1);
        lambdaStreamExc.filter(toUpperCaseStream,"T");
        //lambdaStreamExc.createIntStream(array);
        //Consumer<String> printer = lambdaStreamExc.getLambdaPrinter("start>", "<end");
        //printer.accept("Message body");
        lambdaStreamExc.printMessages(array1,lambdaStreamExc.getLambdaPrinter("msg:","!"));
        lambdaStreamExc.printOdd(lambdaStreamExc.createIntStream(0,5), lambdaStreamExc.getLambdaPrinter("odd number:", "!"));
        int[] array=new int[]{2,5,4,9};
        IntStream intStream=lambdaStreamExc.createIntStream(array);
        List<Integer> integerList=lambdaStreamExc.toList(intStream);
        Stream s=integerList.stream().map(n->integerList);
        Stream<Integer> square=lambdaStreamExc.flatNestedInt(s);

    }
}
