package ch.denismueller.shapeareacalculator;

class ShapeAttribute {
    private final double lowerExclusiveBound;
    private final double upperExclusiveBound;
    private final String errorMessage;
    private final String name;
    private double value;

    public ShapeAttribute(String name, double lowerExclusiveBound, double upperExclusiveBound, String errorMessage) {
        this.name = name;
        this.lowerExclusiveBound = lowerExclusiveBound;
        this.upperExclusiveBound = upperExclusiveBound;
        this.errorMessage = errorMessage;

        // TODO: i want to ensure that this is value needs to be set before it's defined... is there a better way to do this? (setting to null is not possible)
        value = -999;
    }

    public String getName() {
        return name;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isValid() {
        return lowerExclusiveBound < value && value < upperExclusiveBound;
    }
}
