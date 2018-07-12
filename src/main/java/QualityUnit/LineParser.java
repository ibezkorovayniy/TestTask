package QualityUnit;

public class LineParser {

    public Line parseLine(String inputString) {

        String spaceDelimiter = "[ ]";
        String pointDelimiter = "[.]";

        Line line = new Line();

        String [] lineTokens = inputString.split(spaceDelimiter);

        String [] first = lineTokens[1].split(pointDelimiter);
        if(first.length == 2) {
            line.setServiceId(Integer.parseInt(first[0]));
            line.setVariationId(Integer.parseInt(first[1]));
        } else {
            line.setServiceId(Integer.parseInt(first[0]));
            line.setVariationId(0);
        }

        String [] second = lineTokens[2].split(pointDelimiter);
        if(second.length == 3) {
            line.setQuestionTypeId(Integer.parseInt(second[0]));
            line.setCategoryId(Integer.parseInt(second[1]));
            line.setSubcategoryId(Integer.parseInt(second[2]));
        } else if(second.length == 2){
            line.setQuestionTypeId(Integer.parseInt(second[0]));
            line.setCategoryId(Integer.parseInt(second[1]));
            line.setSubcategoryId(0);
        } else {
            line.setQuestionTypeId(Integer.parseInt(second[0]));
            line.setCategoryId(0);
            line.setSubcategoryId(0);
        }


        line.setResponseType(lineTokens[3]);

        line.setDate(lineTokens[4]);

        line.setTime(lineTokens[5]);

        return line;
    }

}
