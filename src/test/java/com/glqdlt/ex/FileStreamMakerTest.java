package com.glqdlt.ex;

import com.sun.org.apache.xml.internal.serializer.ToStream;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class FileStreamMakerTest {

    @Test
    public void shouldMakeStream() {
        long uniqueWords = 0;
//        java.nio.file.Files 정적 메소드들은 AutoClose를 지원한다
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("data.txt").toURI()))) {
//                  Stream을 써서 하고 싶었는 데.. count() 를 먼저하든 forEach를 먼저하든 Stream 이 소비되어버려서 날라가버리더라.. 컹. 그래서 콜렉션으로 Stream을 저장하는 형태를 취했다
//                Stream<String> someWords = lines.flatMap(x -> Arrays.stream(x.split(" "))).distinct();
//                uniqueWords = someWords.count();
//                someWords.forEach(System.out::println);

//            일단 이렇게 콜렉션으로 할수도있지만
//                List<String> someWords = lines.flatMap(x -> Arrays.stream(x.split(" "))).distinct().collect(toList());
//                uniqueWords = someWords.size();
//                someWords.forEach(System.out::println);

//            꼭 스트림으로 하겠다면.. 여기서 의미 없는 Map을 통해 찍어주기를 하면된다!
//                uniqueWords = lines.flatMap(x -> Arrays.stream(x.split(" "))).distinct().map(x -> {
//                    System.out.println(x); return x;}).count();


//            오오 인텔리J갓님께서 peek이라는 걸 가르켜주셨다.
            uniqueWords = lines.flatMap(x -> Arrays.stream(x.split(" "))).distinct().peek(System.out::println).count();

        } catch (IOException e) {
            System.out.println("Errrr");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWords);
    }

}