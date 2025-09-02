public class WithPickles extends RacletteDecorator {

    public WithPickles(Raclette raclette) {
        super(raclette);
    }

    @Override
    public int getCalories() {
        return 50 + super.getCalories();
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", cornichons";
    }
}