package Latihan_3;

public class Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape(){
        
    }
    
    public Shape(String color, boolean filled){
        setColor(color);
        setFilled(filled);
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    @Override
    public String toString(){
        return "";
    }
    
}
