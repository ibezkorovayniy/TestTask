package QualityUnit;

public class QueryParser {

    public Query parseQuery(String inputQuery) {


    String spaceDelimiter = "[ ]";
    String pointDelimiter = "[.]";
    String dushDelimiter = "[-]";

    Query query = new Query();

    String [] queryTokens = inputQuery.split(spaceDelimiter);

    if(queryTokens[1].equals("*")) {
        query.setServiceId(0);
        query.setVariationId(0);
    } else {
        String[] first = queryTokens[1].split(pointDelimiter);
        if (first.length == 2) {
            query.setServiceId(Integer.parseInt(first[0]));
            query.setVariationId(Integer.parseInt(first[1]));
        } else {
            query.setServiceId(Integer.parseInt(first[0]));
            query.setVariationId(0);
        }
    }

    if(queryTokens[2].equals("*")) {
        query.setQuestionTypeId(0);
        query.setCategoryId(0);
        query.setSubcategoryId(0);
    } else {
        String[] second = queryTokens[2].split(pointDelimiter);
        if (second.length == 3) {
            query.setQuestionTypeId(Integer.parseInt(second[0]));
            query.setCategoryId(Integer.parseInt(second[1]));
            query.setSubcategoryId(Integer.parseInt(second[2]));
        } else if (second.length == 2) {
            query.setQuestionTypeId(Integer.parseInt(second[0]));
            query.setCategoryId(Integer.parseInt(second[1]));
            query.setSubcategoryId(0);
        } else {
            query.setQuestionTypeId(Integer.parseInt(second[0]));
            query.setCategoryId(0);
            query.setSubcategoryId(0);
        }
    }
        query.setResponseType(queryTokens[3]);

    String [] date = queryTokens[4].split(dushDelimiter);

    if(date.length == 2) {
        query.setDateFrom(date[0]);
        query.setDateTo(date[1]);
    } else {
        query.setDateFrom(date[0]);
    }
    return query;
}

}
