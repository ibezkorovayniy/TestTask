package QualityUnit;

public abstract class AbstractParser {

    private final String SPACEDELIMITER = "[ ]";
    private final String POINTDELIMITER = "[.]";
    private String[] inputTokens;

    public void populateServiceData(String input, AbstractData abstractData) {
        inputTokens = input.split(SPACEDELIMITER);
        String[] service = inputTokens[1].split(POINTDELIMITER);
        if (service.length == 2) {
            abstractData.setServiceId(Integer.parseInt(service[0]));
            abstractData.setVariationId(Integer.parseInt(service[1]));
        } else {
            abstractData.setServiceId(Integer.parseInt(service[0]));
            abstractData.setVariationId(0);
        }
    }

    public void populateQuestionTypeData(String input, AbstractData abstractData) {
        inputTokens = input.split(SPACEDELIMITER);
        String[] questionType = inputTokens[2].split(POINTDELIMITER);
        if (questionType.length == 3) {
            abstractData.setQuestionTypeId(Integer.parseInt(questionType[0]));
            abstractData.setCategoryId(Integer.parseInt(questionType[1]));
            abstractData.setSubcategoryId(Integer.parseInt(questionType[2]));
        } else if (questionType.length == 2) {
            abstractData.setQuestionTypeId(Integer.parseInt(questionType[0]));
            abstractData.setCategoryId(Integer.parseInt(questionType[1]));
            abstractData.setSubcategoryId(0);
        } else {
            abstractData.setQuestionTypeId(Integer.parseInt(questionType[0]));
            abstractData.setCategoryId(0);
            abstractData.setSubcategoryId(0);
        }
    }
}



