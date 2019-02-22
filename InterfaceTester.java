
/**
 * Write a description of class InterfaceTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InterfaceTester
{
    public static void main(String[] args){
        Student a = new Student("Jon",16);
        Student b = new Student("Robert",16);
        Student c = new Student("Dale",13);
        a.accumScore(10,10);
        a.accumScore(20,20);
        a.accumScore(19,20);
        b.accumScore(18,20);
        b.accumScore(17,20);
        b.accumScore(8,10);
        c.accumScore(8,10);
        c.accumScore(20,20);
        c.accumScore(15,20);
        
        Weather w = new Weather("Yeehaw");
        Weather x = new Weather("Country");
        Weather y = new Weather("Time");
        w.addTempInOrder(70);
        w.addTempInOrder(70);
        w.addTempInOrder(70);
        x.addTempInOrder(56);
        x.addTempInOrder(48);
        x.addTempInOrder(68);
        y.addTempInOrder(20);
        y.addTempInOrder(49);
        y.addTempInOrder(40);
        
        Measurable[] mbl = {a,b,c};
        Measurable[] mbl2 = {w,x,y};
        for(Measurable m : mbl){
            System.out.println("Student : " + m.toString());
        }
        System.out.println("average : " + average(mbl));
        
        for(Measurable n : mbl2){
            System.out.println("Weather : " + n.toString());
        }
        System.out.println("Weather : " + average(mbl2));
          
    }
    
    public static double average(Measurable[] arr){
        double sum=0;
        double count=0;
        for(Measurable m : arr){
            sum+= m.getMeasure();
            count++;
        }
        return sum/count;
    }
}
