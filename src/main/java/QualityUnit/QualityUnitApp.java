package QualityUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QualityUnitApp {

    public static void main(String[] args) {

        List<List<Integer>> resultList;
        Matcher matcher = new Matcher();
        List<Line> lineList = new ArrayList<>();
        List<Query> queryList = new ArrayList<>();
        LineParser lineParser = new LineParser();
        QueryParser queryParser = new QueryParser();

        String pathName = args[0];
        File file = new File(pathName);

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                if (!str.equals("")) {
                    if (str.charAt(0) == 'C') {
                        lineList.add(lineParser.parseLine(str));
                    } else if (str.charAt(0) == 'D') {
                        queryList.add(queryParser.parseQuery(str));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }

        resultList = matcher.findMatches(lineList, queryList);
        print(resultList);

    }


    private static void print(List<List<Integer>> resultList) {
        resultList.stream()
                .mapToDouble((integers->integers.stream()
                        .collect(Collectors.summarizingInt(Integer::intValue))
                        .getAverage()))
                .forEach(x -> {
                    if(x < 1) {
                        System.out.println("-");
                    }else {
                        System.out.println((int)x);
                    }
                });
    }
}

