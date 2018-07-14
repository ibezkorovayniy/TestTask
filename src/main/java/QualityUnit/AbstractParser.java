package QualityUnit;

public abstract class AbstractParser {

    private String[] inputTokens;
    private String spaceDelimiter = "[ ]";
    private String pointDelimiter = "[.]";

    public void populateServiceData(String input, AbstractData abstractData) {

        inputTokens = input.split(spaceDelimiter);

        String[] service = inputTokens[1].split(pointDelimiter);

        if (service.length == 2) {
            abstractData.setServiceId(Integer.parseInt(service[0]));
            abstractData.setVariationId(Integer.parseInt(service[1]));
        } else {
            abstractData.setServiceId(Integer.parseInt(service[0]));
            abstractData.setVariationId(0);
        }
    }

    public void populateQuestionTypeData(String input, AbstractData abstractData) {

            inputTokens = input.split(spaceDelimiter);
            String [] questionType = inputTokens[2].split(pointDelimiter);
            if(questionType.length == 3) {
                abstractData.setQuestionTypeId(Integer.parseInt(questionType[0]));
                abstractData.setCategoryId(Integer.parseInt(questionType[1]));
                abstractData.setSubcategoryId(Integer.parseInt(questionType[2]));
            } else if(questionType.length == 2){
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



