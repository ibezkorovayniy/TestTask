package QualityUnit;

public class LineParser extends AbstractParser{

    public Line parseLine(String inputString) {
        Line line = new Line();
        String spaceDelimiter = "[ ]";
        populateServiceData(inputString, line);
        populateQuestionTypeData(inputString, line);
        String [] lineTokens = inputString.split(spaceDelimiter);
        line.setResponseType(lineTokens[3]);
        line.setDate(lineTokens[4]);
        line.setTime(lineTokens[5]);
        return line;
    }


}
