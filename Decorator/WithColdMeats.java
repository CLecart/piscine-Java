public class WithColdMeats extends RacletteDecorator {

    public WithColdMeats(Raclette raclette) {
        super(raclette);
    }

    @Override
    public int getCalories() {
        return 350 + super.getCalories();
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", charcuterie";
    }
}