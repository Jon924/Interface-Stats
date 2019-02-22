import java.util.*;
/**
 * Write a description of class Student here.
 *
 * @author Jon Grey
 * @version 1.0
 */
public class Student extends Person implements Measurable
{
    // instance variables - replace the example below with your own
    private int scoreNum;
    private int[] pointEarned = new int[10];
    private int[] pointPoss = new int[10];

    /**
     * Constructor for objects of class Student
     */
    public Student(String name, int age)
    {
        super(name, age);
    }
    
    
    public void dropLowestScore() {
        int smallIndx = 0;
        double minimumValue = pointEarned[0];
        for (int i = 0; i < pointEarned.length; i ++) {
            if( ((double)pointEarned[i]) / pointPoss[i] < minimumValue){ 
                minimumValue = ((double)pointEarned[i]) / pointPoss[i];
                smallIndx = i;
            }
        }
        for(int i = smallIndx; i < pointEarned.length - 1; i ++) {
            pointEarned[i] = pointEarned[i + 1];
            pointPoss[i] = pointPoss[i + 1];
        }
    }
    public double calcGrade() {
        int total = 0, maximum = 0;
        for(int get : pointEarned){
            total += get;
        }
        for(int max : pointPoss){
            maximum += max;
        }
        return ((double)total) / maximum * 100.0;
    }
    public void accumScore(int score, int maximum) {
        if(pointEarned[pointEarned.length - 1] != 0) {
            System.out.println("You've filled up the array. No more scores please.");
            return;
        }
        pointEarned[scoreNum] = score;
        pointPoss[scoreNum] = maximum;
        scoreNum += 1;
    }
    
    public int getMeasure(){
        int mean = (int)(calcGrade());
        return mean;
    }
    
    public String toString(){
        return Arrays.toString(pointEarned).replace("[", "").replace("]", "")
            + "\n" + Arrays.toString(pointPoss).replace("[", "").replace("]", "");
    }
}