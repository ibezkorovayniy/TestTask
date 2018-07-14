package QualityUnit;

public class QueryParser extends AbstractParser{

    public Query parseQuery(String inputQuery) {

        Query query = new Query();

    String spaceDelimiter = "[ ]";
    String dushDelimiter = "[-]";

    String [] queryTokens = inputQuery.split(spaceDelimiter);

    if(queryTokens[1].equals("*")) {
        query.setServiceId(0);
        query.setVariationId(0);
    } else {
        populateServiceData(inputQuery, query);
    }

    if(queryTokens[2].equals("*")) {
        query.setQuestionTypeId(0);
        query.setCategoryId(0);
        query.setSubcategoryId(0);
    } else {
        populateQuestionTypeData(inputQuery, query);
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
