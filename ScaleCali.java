package phidgetscale;

import com.phidget22.*;
import java.util.Scanner;

public class scalecali {
    //Define
    static VoltageRatioInput scale;
    
    public static double getAverage()throws Exception{
        double average = 0;
        int count = 0;
        System.out.println("Averaging Value...");
        while(count < 64){
            average += scale.getVoltageRatio();
            count += 1;
            Thread.sleep(20);
        }
        return average/count;
    }
    
    public static void main(String[] args) throws Exception{
        try (Scanner scan = new Scanner(System.in)) {
			//Create
			scale = new VoltageRatioInput();
			
			//Open
			scale.open(1000);
			
			scale.setDataInterval(scale.getMinDataInterval());
			
			System.out.println("Make sure nothing is on your scale and press enter");
			//display message
			scan.nextLine();
			double offset = getAverage();
			
			System.out.println("Place a known weight on the Scale, Type the weight in kilograms and press Enter");
			double knownWeight = Double.parseDouble(scan.nextLine());
			
			double measuredWeight = getAverage();
			
			double slope = knownWeight / (measuredWeight - offset);
			//slope formula
			System.out.println("Your new slope value is: " + Math.round(slope));
			//print out new slope value
		}
        
    }    
    
} 
  
 
/*

Item #1: My Phone 0.202kg
Item #2: Alisha's Phone 0.204 kg
Item #3: Gordon's Calculator 0.203kg

Item #1:
Make sure nothing is on your scale and press enter

Averaging Value...
Place a known weight on the Scale, Type the weight in kilograms and press Enter
0.202
Averaging Value...
Your new slope value is: 25178

Item #2:
Make sure nothing is on your scale and press enter

Averaging Value...
Place a known weight on the Scale, Type the weight in kilograms and press Enter
0.204
Averaging Value...
Your new slope value is: 24986

Item #3:
Make sure nothing is on your scale and press enter

Averaging Value...
Place a known weight on the Scale, Type the weight in kilograms and press Enter
0.203
Averaging Value...
Your new slope value is: 24834

*/
