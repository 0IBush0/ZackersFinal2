package phidgetscale;

import com.phidget22.*;

public class autocalc 
{
    static VoltageRatioInput scale;
    
    public static double getAverage()throws Exception
    {
        double average = 0;
        int count = 0;
        System.out.println("Averaging Value...");
        //print out value
        while(count < 64)
        {
            average += scale.getVoltageRatio();
            count += 1;
            Thread.sleep(20);
            //time
        }
        return average/count;
        
     }
     
}
