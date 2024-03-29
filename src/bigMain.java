
/*
 * This is what you have:
 * files of data in a directory called Data, in a specific path (C:/ProfOmar/)
 * the data will be in C:/ProfOmar/Data. You'll find the data of all stocks and ETFs
 * for example the data for IBM will be in IBM_Daily.csv (comma separated file)
 * String fileName = symbol + "_Daily.csv"
 * You have two special files:  stocks.txt and ETFs.txt in stocks.txt you have all 
 * the symbols of the stocks you need to test 171 stocks
 * in ETFs.txt you will find all the ETFs you need to test.
 * 
 * What to generate? Stats concerning stocks (for all stocks together)
 * Stats for ETFs all together, then combine the results (this one is easy)
 * We will test for 17 combinations of loss and target 
 * 
 */
public class bigMain {
	public static void main(String[] args) {
		double[] target = new double[4];
		target[0] = 0.01;
		target[1] = 0.02;
		target[2] = 0.05;
		target[3] = 0.1;
		double[] loss = new double[4];
		loss[0] = 0.01;
		loss[1] = 0.02;
		loss[2] = 0.05;
		loss[3] = 0.1;
		String path = "E:\\Undergraduate\\Fifth Semester - Lagcc\\Data Structures\\Programs\\Project\\Data\\"; //your path here 
		//if you use Linux "/home/yourhome/.../.../"
		for (int i =0; i<4; i++) {//test all combinations of loss and target
			for (int j =0; j<4; j++){
				Simulator sim = new Simulator(path, "stocks.txt", loss[i], target[j]);
				//First call object you create will be 
				// Simulator sim = new Simulator("C:\\ProfOmar286_18\\Data\\", "stocks.txt", 0.01, 0.01);  
				sim.run();
				//display the stats for these parameters loss[i], target[j]
				tradeArray Tr = sim.getTrades();
				//print the stats
				System.out.println(loss[i]+", " + target[j]+", " + Tr.getStats().toString());
				Simulator simETF = new Simulator(path, "ETFs.txt", loss[i], target[j]);
				simETF.run();
				//display the stats for these parameters loss[i], target[j]
				tradeArray Tr1 = simETF.getTrades();
				//print the stats
				System.out.println(loss[i]+", " + target[j]+", " + Tr1.getStats().toString());
				//Print stats for the combination add the trades together
				Tr.addArray(Tr1);//Add trades in Tr1 to Tr
				System.out.println(loss[i]+", " + target[j] +", "+ Tr.getStats().toString());		
			}
		}
		//we need to test what if we exit the trade the same day as we enter it at the close 
		//we call that loss=0, target = 0
		Simulator sim = new Simulator(path, "stocks.txt", 0.0, 0.0);
		sim.run();
		//display the stats for these parameters loss[i], target[j]
		tradeArray Tr = sim.getTrades();
		//print the stats
		System.out.println(0.0+", " + 0.0 +", "+ Tr.getStats().toString());
		Simulator simETF = new Simulator(path, "ETFs.txt", 0.0, 0.0);
		simETF.run();
		//display the stats for these parameters loss[i], target[j]
		tradeArray Tr1 = simETF.getTrades();
		//print the stats
		System.out.println(0.0+", " + 0.0+", " + Tr1.getStats().toString());
		//Print stats for the combination add the trades together
		Tr.addArray(Tr1);
		System.out.println(0.0+", " + 0.0 +", "+ Tr.getStats().toString());	
	}
}