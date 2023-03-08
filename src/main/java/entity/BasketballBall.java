package entity;

import java.util.Objects;
import java.util.Set;

public class BasketballBall implements Ball{

    private String modelName;
    private int diameter;
    private int weight;
    private int pressure;
    private Color color;

    public BasketballBall(String modelName, int diameter, int weight, int pressure, Color color) {
        this.modelName = modelName;
        this.diameter = diameter;
        this.weight = weight;
        this.pressure = pressure;
        this.color = color;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public int getDiameter() {
        return diameter;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getPressure() {
        return pressure;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketballBall that = (BasketballBall) o;
        return diameter == that.diameter && weight == that.weight && pressure == that.pressure && Objects.equals(modelName, that.modelName) && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, diameter, weight, pressure, color);
    }
}
