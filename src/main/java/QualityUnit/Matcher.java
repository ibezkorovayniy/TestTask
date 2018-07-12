package QualityUnit;

import java.util.ArrayList;
import java.util.List;

public class Matcher {

    public List<List<String>> findMatches(List<Line> lineList, List<Query> queryList) {
        List<List<String>> listResults = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < queryList.size(); i++) {
            Query tempQuery = queryList.get(i);
            List<String> result = new ArrayList<>();

            for (int j = 0; j < lineList.size(); j++) {
                Line tempLine = lineList.get(j);

                if (tempQuery.getServiceId() != 0) {

                    if (tempQuery.getServiceId() != tempLine.getServiceId()) {

                    } else if (tempQuery.getQuestionTypeId() != 0) {

                        if (tempQuery.getQuestionTypeId() != tempLine.getQuestionTypeId()) {

                        } else if (!tempQuery.getResponseType().equals(tempLine.getResponseType())) {

                        } else if (tempQuery.getDateTo() == null && !tempQuery.getDateFrom().equals(tempLine.getDate())) {

                        } else if (tempLine.getDate().isAfter(tempQuery.getDateTo()) || tempLine.getDate().isBefore(tempQuery.getDateFrom())) {

                        } else if (tempQuery.getVariationId() != 0 && tempQuery.getVariationId() != tempLine.getVariationId()) {

                        } else if (tempQuery.getCategoryId() != 0 && tempQuery.getCategoryId() != tempLine.getCategoryId()) {

                        } else if (tempQuery.getSubcategoryId() != 0 && tempQuery.getSubcategoryId() != tempLine.getSubcategoryId()) {

                        } else {
                            result.add(tempLine.getTime());
                        }

                    } else if (!tempQuery.getResponseType().equals(tempLine.getResponseType())) {

                    } else if (tempQuery.getDateTo() == null && !tempQuery.getDateFrom().equals(tempLine.getDate())) {

                    } else if (tempLine.getDate().isAfter(tempQuery.getDateTo()) || tempLine.getDate().isBefore(tempQuery.getDateFrom())) {

                    } else if (tempQuery.getVariationId() != 0 && tempQuery.getVariationId() != tempLine.getVariationId()) {

                    } else {
                        result.add(tempLine.getTime());
                    }

                } else if (tempQuery.getQuestionTypeId() != 0) {

                    if (tempQuery.getQuestionTypeId() != tempLine.getQuestionTypeId()) {

                    } else if (!tempQuery.getResponseType().equals(tempLine.getResponseType())) {

                    } else if (tempQuery.getDateTo() == null && !tempQuery.getDateFrom().equals(tempLine.getDate())) {

                    } else if (tempLine.getDate().isAfter(tempQuery.getDateTo()) || tempLine.getDate().isBefore(tempQuery.getDateFrom())) {

                    } else if (tempQuery.getCategoryId() != 0 && tempQuery.getCategoryId() != tempLine.getCategoryId()) {

                    } else if (tempQuery.getSubcategoryId() != 0 && tempQuery.getSubcategoryId() != tempLine.getSubcategoryId()) {

                    } else {
                        result.add(tempLine.getTime());
                    }

                } else if (!tempQuery.getResponseType().equals(tempLine.getResponseType())) {

                } else if (tempQuery.getDateTo() == null && !tempQuery.getDateFrom().equals(tempLine.getDate())) {

                } else if (tempLine.getDate().isAfter(tempQuery.getDateTo()) || tempLine.getDate().isBefore(tempQuery.getDateFrom())) {

                } else {
                    result.add(tempLine.getTime());
                }

            }
            listResults.add(result);
        }
        return listResults;
    }


}
