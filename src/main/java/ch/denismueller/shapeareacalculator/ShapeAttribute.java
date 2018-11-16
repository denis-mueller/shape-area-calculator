package ch.denismueller.shapeareacalculator;

public class ShapeAttribute {
    private int lowerInclusiveBound;
    private int upperInclusiveBound;
    private String errorMessage;
    private int value;

    public ShapeAttribute(int lowerInclusiveBound, int upperInclusiveBound, String errorMessage) {
        this.lowerInclusiveBound = lowerInclusiveBound;
        this.upperInclusiveBound = upperInclusiveBound;
        this.errorMessage = errorMessage;

        value = 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isValid(){
        return lowerInclusiveBound <= value && value <= upperInclusiveBound;
    }
}
