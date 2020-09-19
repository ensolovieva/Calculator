public class Rimskie extends Dopclass {

    private String rim_value1;
    private String rim_value2;

    private int rezultat_int;
    private String rezultat_string;

    private int rim_value1_int;
    private int rim_value2_int;

    private String sign = "";
    private final String[] rim_letters = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Rimskie(String value1, String value2)
    {
        this.rim_value1 = value1; this.rim_value2 = value2;
        this.rim_value1_int = convert_to_int(rim_value1); this.rim_value2_int = convert_to_int(rim_value2);
    }
    private String convert_in_Romes(int a, int ostatok)
    {
        ostatok = a % 10;
        if (ostatok != 0) {
            try
            {
                return convert_in_Romes(a - ostatok, 0) + rim_letters[ostatok - 1];
            } catch (ArrayIndexOutOfBoundsException e)
            {
                sign = "-";
                return convert_in_Romes(a - ostatok, 0) + rim_letters[(ostatok + 1) * -1];
            }
        }

        if (a > 0)
        {
            a = a - 10;
            return convert_in_Romes(a,0) + "X";
        } else if (a < 0)
        {
            a = a + 10;
            return convert_in_Romes(a,0) + "X";
        }   else
        {
            return sign;
        }
    }

    @Override
    public void deduction()
    {
        rezultat_int = rim_value1_int - rim_value2_int; rezultat_string = convert_in_Romes(rezultat_int, rezultat_int);
    }

    @Override
    public void summa()
    {
        rezultat_int = rim_value1_int + rim_value2_int; rezultat_string = convert_in_Romes(rezultat_int, rezultat_int);
    }

    @Override
    public void division()
    {
        try {
            rezultat_int = rim_value1_int / rim_value2_int; rezultat_string = convert_in_Romes(rezultat_int, rezultat_int);
        } catch (ArithmeticException e) {
            return;
        }
    }

    @Override
    public void mult()
    {
        rezultat_int = rim_value1_int * rim_value2_int; rezultat_string = convert_in_Romes(rezultat_int, rezultat_int);
    }

    @Override
    public int getRezult()
    {
        return rezultat_int;
    }
    public String getStringRezult() {
        return rezultat_string;
    }

    private int convert_to_int(String rim_value)
    {
        char[] value_char = rim_value.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++)
        {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;

                default:
                    System.out.println("Ошибка");
            }
        }
        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++)
        {
            if (values_int[i] >= values_int[i+1])
            {
                result += values_int[i+1];
            } else if (values_int[i] < values_int[i+1])
            {
                result = result + values_int[i+1] - 2;
            }
        }
        return result;
    }

    public String getRim_value1()
    {
        return rim_value1;
    }

    public String getRim_value2()
    {
        return rim_value2;
    }

    public void setRim_value1(String rim_value1)
    {
        this.rim_value1 = rim_value1;
    }

    public void setRim_value2(String rim_value2)
    {
        this.rim_value2 = rim_value2;
    }

    public int getRim_value1_int()
    {
        return rim_value1_int;
    }

    public int getRim_value2_int()
    {
        return rim_value2_int;
    }

    public void setRim_value1_int(int rim_value1_int)
    {
        this.rim_value1_int = rim_value1_int;
    }

    public void setRim_value2_int(int rim_value2_int)
    {
        this.rim_value2_int = rim_value2_int;
    }
}
