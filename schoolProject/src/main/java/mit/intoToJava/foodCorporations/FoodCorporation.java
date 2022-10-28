package mit.intoToJava.foodCorporations;


/**
 * Calculates pay of employees.
 */
public class FoodCorporation {
    /**
     * This method will take two doubles, basePay and hoursWorked, as inputs.
     * Then determine how much to pay an employee based on their hours worked and base pay.
     * will throw errors if the employee has worked over 60 hours or if the base pay is below 8.00.
     * For any hours worked over 40 hours, the employee gets paid at 1.5 times base pay.
     * if no errors are thrown, a statement gets printed how many hours the employee has worked and earnings.
     */
    private static void payCalculator(double basePay, double hoursWorked) {
        if( (hoursWorked > 60) || (hoursWorked < 0))
            System.out.println("ERROR: Employee worked over 60 hours or the hours you typed are negative.");

        else if(basePay < 8.00)
            System.out.println("ERROR: Employee is being payed below base pay($8.00/hr) or the base pay you typed is negative.");

        else {
            double hoursOver40 = hoursWorked - 40;
            double earnings = 0.0;
            if(hoursOver40 <= 0)
                earnings = hoursWorked * basePay;
            else
                earnings = 40 * basePay + ( hoursOver40 * (basePay * 1.5));

            System.out.println("Employee has worked " + hoursWorked + " hours and earned $" + earnings + ".");
        }
    }
    public static void main(String[] args) {
        payCalculator(7.50,35);
        payCalculator(8.20,47);
        payCalculator(10.00,73);
    }


}
