public class Square extends Shape {
    private double length;

    Square(double length){
        this.length = length;
    }

    double area(){
        return length * length;
    }
}
