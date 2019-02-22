
/**
 * Write a description of class Weather here.
 *
 * @author jon
 * @version 1.0
 */
public class Weather implements Measurable
{
    private String cityName;
    private int[] temps;
    private int numOfTemps;
    private static final int MAX_COUNT = 6;
    
    public Weather(String name){
        cityName = name;
        temps = new int[MAX_COUNT];
        numOfTemps=0;
    }
    
    public String toString(){
        String str = cityName;
        for(int i=0;i<numOfTemps;i++){
            str+= "\n\t" + temps[i];
        }
        return str;
    }
    
    public int findIndexToInsert(int temp){
        for(int i=0;i<numOfTemps;i++){
            if(temp<temps[i]){
                return i;
            }
        }
        return numOfTemps;
    }
    
    public boolean addTempInOrder(int latestTemp){
        if(numOfTemps==MAX_COUNT){
            return false;
        }
        int index = findIndexToInsert(latestTemp);
        for(int i=numOfTemps;i>=0;i--){
            if(i>index){
                temps[i]=temps[i-1];
            }else{
                temps[i]=latestTemp;
                break;
            }
        }
        numOfTemps++;
        return true;
    }
    
    public int[] calcMeanAndMedian(){
        int[] mAndM = new int[2];
        int sum=0;
        for(int i=0; i<numOfTemps;i++){
            sum+=temps[i];
        }
        if(numOfTemps!=0)
        mAndM[0] = (sum/numOfTemps);
        
        int median;
        if(numOfTemps%2==1||numOfTemps==0){
            median = temps[(numOfTemps-1)/2];
        }else{
            median = (temps[numOfTemps/2]+temps[numOfTemps/2 -1]);
        }
        mAndM[1] = median;
        return mAndM;
    }    
    
    public int getMeasure(){
        int[] m = calcMeanAndMedian();
        return m[0];
    }
    
}
