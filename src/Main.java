import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String digits[][] = new String[4][4];

        for (int i = 0; i < digits.length; i++){
            for ( int j = 0; j < digits[0].length; j++){
                digits[i][j] = "10";
            }
        }   //заполняем массив

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        digits[1][2] = in.nextLine();    // одну ячейку предлагаем ввести пользователю

        try {
            System.out.println(makeSum(digits));
        }catch (MyArraySizeException ex){
            System.out.println(ex.toString());
        }catch (MyArrayDataException ex){
            System.out.println(ex.toString());
        }finally {
            System.out.println("что смогла");
        }
    }

    private static int makeSum(String[][] digits){
        int sumResult = 0;

        if (digits.length != 4) {
            throw new MyArraySizeException("Первый размер плохой");  //проверяем первое измерение =4 или нет
        }
        for (int i = 0; i < 4; i++){   //проверяем измерения остальных массивов =4 или нет
            if (digits[i].length != 4) {
                throw new MyArraySizeException("Второй размер плохой");
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j< 4; j++){
                try {
                    sumResult += Integer.parseInt(digits[i][j]);
                }catch (NumberFormatException ex){
                    throw new MyArrayDataException("Элемент " + i + ", " + j + " - плохой");
                }
            }

        }
        return sumResult;
    }


}
