public class ConcatStrategy implements OperationStrategy {
    @Override
    public int execute(int a, int b) {
        String concat = String.valueOf(a) + String.valueOf(b);
        return Integer.parseInt(concat);
    }
}