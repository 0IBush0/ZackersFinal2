import com.phidget22.*;

public class scalelb {
    public static void main(String[] args) throws Exception{

        //Create
        VoltageRatioInput scale = new VoltageRatioInput();
        
        //Open
        scale.open(1000);
        
        //Use your Offset Value
        double offsetValue = 3.530131654595086E-5;
        
        //Use your Phidgets
        while(true)
        {
            double weight = (4700 * (scale.getVoltageRatio() - offsetValue)) * 2.205;
            
            System.out.println(String.format("%.3f lb", weight));      
            //display weight in lbs
            Thread.sleep(250);
          
        }
    }    
}
