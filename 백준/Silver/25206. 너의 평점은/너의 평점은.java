import java.util.*;

class Main {
    public static double gradeCalc(String grade) {
        if(grade.equals("A+")) return 4.5;
        else if(grade.equals("A0")) return 4.0;
        else if(grade.equals("B+")) return 3.5;
        else if(grade.equals("B0")) return 3.0;
        else if(grade.equals("C+")) return 2.5;
        else if(grade.equals("C0")) return 2.0;
        else if(grade.equals("D+")) return 1.5;
        else if(grade.equals("D0")) return 1.0;
        else return 0.0;
    }
    
    public static void main(String[] args) {
        double result = 0;
        double sum = 0;
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            sc.next();
            double point = sc.nextDouble();
            String grade = sc.next();
            
            if(grade.equals("P")) continue;
            
            result += point * gradeCalc(grade);
            sum += point;
        }
        
        result /= sum;
        System.out.println(result);
    }
}