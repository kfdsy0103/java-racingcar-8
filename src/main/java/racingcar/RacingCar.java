package racingcar;

public class RacingCar {

    private String name;
    private int forwardCount;

    public RacingCar(String name, int forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void moveForward() {
        this.forwardCount++;
    }
}
