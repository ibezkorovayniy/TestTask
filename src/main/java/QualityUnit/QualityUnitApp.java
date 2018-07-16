package QualityUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        for (List<Integer> list: resultList) {
            if (list.size() == 0) {
                System.out.println("–");
                continue;
            }
            int avg = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                avg += list.get(i);
            }
            avg /= list.size();

            System.out.println(avg);
        }
    }
}

