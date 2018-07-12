package QualityUnit;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String D1 = "D 1.1 8 P 01.01.2012-01.12.2012";
        String D2 = "D 1 * P 08.10.2012-20.11.2012";
        String D3 = "D 3 10 P 01.12.2012";

        String C1 = "C 1.1 8.15.1 P 15.10.2012 83";
        String C2 = "C 1 10.1 P 01.12.2012 65";
        String C3 = "C 1.1 5.5.1 P 01.11.2012 117";
        String C4 = "C 3 10.2 N 02.10.2012 100";

        List<Line> lineList = new ArrayList<>();
        List<Query> queryList = new ArrayList<>();
        List<List<String>> resultList;

        LineParser lineParser = new LineParser();

        lineList.add(lineParser.parseLine(C1));
        lineList.add(lineParser.parseLine(C2));
        lineList.add(lineParser.parseLine(C3));
        lineList.add(lineParser.parseLine(C4));

        QueryParser queryParser = new QueryParser();

        queryList.add(queryParser.parseQuery(D1));
        queryList.add(queryParser.parseQuery(D2));
        queryList.add(queryParser.parseQuery(D3));

        Matcher matcher = new Matcher();

        resultList = matcher.findMatches(lineList, queryList);
        for(List<String> list : resultList) {
            if(list.size() == 0) {
                System.out.println("–");
                break;
            }
            int avg = 0;
                for(int i = list.size()-1; i >= 0; i--) {
                    avg += Integer.parseInt(list.get(i));
                }
                avg /= list.size();

            System.out.println(avg);
        }
    }

}

