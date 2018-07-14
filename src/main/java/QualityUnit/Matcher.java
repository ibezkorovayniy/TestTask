package QualityUnit;

import java.util.ArrayList;
import java.util.List;

public class Matcher {

    public List<List<Integer>> findMatches(List<Line> lineList, List<Query> queryList) {
        List<List<Integer>> listResults = new ArrayList<>();

        for (Query tempQuery: queryList) {
            List<Integer> result = new ArrayList<>();

            for (Line tempLine: lineList) {
                if ((tempQuery.getServiceId() == 0 || tempQuery.getServiceId() == tempLine.getServiceId())
                        && (tempQuery.getVariationId() == 0 || tempQuery.getVariationId() == tempLine.getVariationId())
                        && (tempQuery.getQuestionTypeId() == 0 || tempQuery.getQuestionTypeId() == tempLine.getQuestionTypeId())
                        && (tempQuery.getCategoryId() == 0 || tempQuery.getCategoryId() == tempLine.getCategoryId())
                        && (tempQuery.getSubcategoryId() == 0 || tempQuery.getSubcategoryId() == tempLine.getSubcategoryId())
                        && (tempQuery.getResponseType().equals(tempLine.getResponseType()))
                        && ((tempQuery.getDateTo() == null && tempQuery.getDateFrom().equals(tempLine.getDate()))
                            || (tempLine.getDate().isAfter(tempQuery.getDateFrom())
                                && tempLine.getDate().isBefore(tempQuery.getDateTo())))) {

                    result.add(tempLine.getTime());
                }
            }
            listResults.add(result);
        }
        return listResults;
    }
}

