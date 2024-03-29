
public class Stats {
	public int numberOfTrades, numberLong, numberShort, numberWinners, numberLosers;
	public int longWinners, longLosers, shortWinners, shortLosers;
	public int numberDays, numberLongDays, numberShortDays;
	double totalWinnings, totalLoss, totalLongWinnings, totalLongLoss, totalShortWinnings;
	double totalShortLoss;
	
	public Stats() {
		numberOfTrades= numberLong= numberShort= numberWinners= numberLosers = 0;
		longWinners= longLosers= shortWinners= shortLosers = 0;
		numberDays= numberLongDays= numberShortDays=0;
		totalWinnings= totalLoss= totalLongWinnings= totalLongLoss= totalShortWinnings = 0.0;
		totalShortLoss = 0.0;
		
	}
	
	//TODO
	public String toString() {
		//display  numberOfTrades PercentWinners(numberWinners/numberOfTrades*100) AverageProfit((totalWinnings+ totalLoss)/numberOfTrades)
		//numberLong, PercentLongwinners, averageProfitLong, numberShort, percent Shortwinners, averageProfitShort, averageHoldingPeriod(numberDays/numberOfTrades)
		//numbers separated by comma.
		String st = numberOfTrades +", " + ((double)numberWinners/numberOfTrades*100.0) + ", " + ((totalWinnings+ totalLoss)/numberOfTrades) + ", " +
				numberLong + ", " + ((double)longWinners/numberLong*100.0) + ", " + ((totalLongWinnings+totalLongLoss)/numberLong) + "," +
				numberShort + ", " + ((double)shortWinners/numberShort*100.0) + ", " + ((totalShortWinnings+totalShortLoss)/numberShort) + "," + (double)numberDays/(double)numberOfTrades;
		return st;
	}
}