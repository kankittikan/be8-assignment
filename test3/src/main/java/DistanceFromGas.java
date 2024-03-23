public class DistanceFromGas {
    private Double circumference;
    private Double roundPerLiter;

    public DistanceFromGas(Double circumference, Double roundPerLiter) {
        this.circumference = circumference;
        this.roundPerLiter = roundPerLiter;
    }

    public String calculate(Double liter) {
        //validation
        if(liter <= 0) throw new IllegalArgumentException("input value must greater than 0");
        if(liter >= 1000000) throw new IllegalArgumentException("input value exceed the limit");

        //calculation
        double allRound = roundPerLiter * liter;
        double distance = allRound * (circumference * 0.01);
        return String.valueOf((int) distance / 1000) + " KM";
    }
}
