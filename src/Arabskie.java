public class Arabskie extends Dopclass {

    private int value1;
    private int value2;
    private int rezultat;

    Arabskie(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void summa() {
        this.rezultat = value1 + value2;
    }

    public void deduction() {
        this.rezultat = value1 - value2;
    }

    public void division() {
        try{
            this.rezultat = value1 / value2;
        } catch (ArithmeticException e) {
            System.out.print("Деление на 0! ");
            return;
        }

    }

    public void mult() {
        this.rezultat = value1 * value2;
    }

    @Override
    public int getRezult() {
        return rezultat;
    }

    @Override
    public String getStringRezult() {
        return "" + rezultat;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setResult(int rezultat) {
        this.rezultat = rezultat;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
