import java.io.*;
public class symbolTester {
	//member variables
	private String mPath, mSymbol;
	private double mLoss, mTarget;
	private tradeArray mTrades;
	private barArray mData;
	
	public symbolTester(String symbol, String path, double loss, double target) {
		mPath = path; //first 
		mSymbol = symbol;//first BAC
		mLoss = loss; //first 0.01
		mTarget = target;//first = 0.01
		mTrades = new tradeArray(200, 100);
		mData = new barArray(4000);
	}
	public tradeArray getTrades() {
		return mTrades;
	}	
	private int longPattern(int ind) {
		//Two inside days
        if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
				&& mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
				&& mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
				&& mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
        		&& mData.elementAt(ind+3).High() > mData.elementAt(ind).High())
        {
        	return 3;
        }
        //Three inside days
        if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
                && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
                && mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
                && mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
                && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
        		&& mData.elementAt(ind + 4).High() > mData.elementAt(ind).High())
        {
        	return 4;
        }
        //Four Inside days
       if  (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
                && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
                && mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
                && mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
                && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
        		&& mData.elementAt(ind).High() >= mData.elementAt(ind+4).High()	
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+4).Low() 
        		&& mData.elementAt(ind + 5).High() > mData.elementAt(ind).High())
        {
        	return 5;
        }
        //Five Inside Days
       if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
                && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
               	&& mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
               	&& mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
                && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
        		&& mData.elementAt(ind).High() >= mData.elementAt(ind+4).High()	
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+4).Low()
        		&& mData.elementAt(ind).High() >= mData.elementAt(ind+5).High()	
        		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+5).Low()
        		&& mData.elementAt(ind + 6).High() > mData.elementAt(ind).High())
        {
		return 6;
	}
	return -1;
}
private int shortPattern(int ind) {
	//Two inside days
	 if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
				&& mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
				&& mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
				&& mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
     		&& mData.elementAt(ind+3).Low() < mData.elementAt(ind).Low())
     {
     	return 3;
     }
     //Three inside days
     if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
             && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
             && mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
             && mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
             && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
     		&& mData.elementAt(ind + 4).Low() < mData.elementAt(ind).Low())
     {
     	return 4;
     }
     //Four Inside days
    if  (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
             && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
             && mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
             && mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
             && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
     		&& mData.elementAt(ind).High() >= mData.elementAt(ind+4).High()	
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+4).Low() 
     		&& mData.elementAt(ind + 5).Low() < mData.elementAt(ind).Low())
     {
     	return 5;
     }
     //Five Inside Days
    if (mData.elementAt(ind).High() >= mData.elementAt(ind+1).High()
             && mData.elementAt(ind).Low() <= mData.elementAt(ind+1).Low()
            	&& mData.elementAt(ind).High() >= mData.elementAt(ind+2).High()
            	&& mData.elementAt(ind).Low() <= mData.elementAt(ind+2).Low()
             && mData.elementAt(ind).High() >= mData.elementAt(ind+3).High()
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+3).Low()
     		&& mData.elementAt(ind).High() >= mData.elementAt(ind+4).High()	
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+4).Low()
     		&& mData.elementAt(ind).High() >= mData.elementAt(ind+5).High()	
     		&& mData.elementAt(ind).Low() <= mData.elementAt(ind+5).Low()
     		&& mData.elementAt(ind + 6).Low() < mData.elementAt(ind).Low())
     {
		return 6;
	} 
	return -1;
}
	private boolean SixtyDaysH(int ind, int period){
		for (int i=ind; i>ind-period; i--){
			if(mData.elementAt(i).High() > mData.elementAt(ind).High())
				return false;
		}
		return true;
	}
	private boolean SixtyDaysL(int ind, int period){
		for (int i=ind; i>ind-period; i--){
			if(mData.elementAt(i).Low() < mData.elementAt(ind).Low())
				return false;
		}
		return true;
	}
	void outcomeLong(Trade T, int ind){
		if(mLoss == 0.0 && mTarget == 0.0) {
			//close the trade the same day at the close of the day
			T.close(mData.elementAt(ind).getDate(), mData.elementAt(ind).Close());
			return;
		}
		for (int i= ind; i<mData.size(); i++){
			if(mData.elementAt(i).Low() <= T.getStopLoss()){
				if(mData.elementAt(i).Open() < T.getStopLoss()){
					T.close(mData.elementAt(i).getDate(), mData.elementAt(i).Open());
					T.setHoldingPeriod(i-ind);
					return;
				}else {
					T.close(mData.elementAt(i).getDate(), T.getStopLoss());
					T.setHoldingPeriod(i-ind);
					return;
				}
			}else if(mData.elementAt(i).High() > T.getTarget()){
				if(mData.elementAt(i).Open() > T.getTarget()){
					T.close(mData.elementAt(i).getDate(), mData.elementAt(i).Open());
					T.setHoldingPeriod(i-ind);
					return;
				}else {
					T.close(mData.elementAt(i).getDate(), T.getTarget());
					T.setHoldingPeriod(i-ind);
					return;
				}
			}
		}
		//Neither the stop loss or the target was reached
		//close the trade at the close of the last day.
		T.close(mData.elementAt(mData.size()-1).getDate(), mData.elementAt(mData.size()-1).Close());
	}
	void outcomeShort(Trade T, int ind){
		if(mLoss == 0.0 && mTarget == 0) {
			//close the trade the same day at ther close of the day
			T.close(mData.elementAt(ind).getDate(), mData.elementAt(ind).Close());
			return;
		}
		for (int i= ind; i<mData.size(); i++){
			//if the high exceeds the loss, tehn we have a loss
			if(mData.elementAt(i).High() >= T.getStopLoss()){
				//The price may open higher than the loss, so close at the open
				if(mData.elementAt(i).Open() > T.getStopLoss()){
					T.close(mData.elementAt(i).getDate(), mData.elementAt(i).Open());
					T.setHoldingPeriod(i-ind);
					return;
				}else {
					T.close(mData.elementAt(i).getDate(), T.getStopLoss());
					T.setHoldingPeriod(i-ind);
					return;
				}
			}else if(mData.elementAt(i).Low() < T.getTarget()){
				if(mData.elementAt(i).Open() < T.getTarget()){
					T.close(mData.elementAt(i).getDate(), mData.elementAt(i).Open());
					T.setHoldingPeriod(i-ind);
					return;
				}else {
					T.close(mData.elementAt(i).getDate(), T.getTarget());
					T.setHoldingPeriod(i-ind);
					return;
				}
			}
		}
		//Neither the stop loss or the target was reached
		//close the trade at the close of the last day.
		T.close(mData.elementAt(mData.size()-1).getDate(), mData.elementAt(mData.size()-1).Close());
			
	}
	public boolean test() {
		//load the data into mData
		if (!load()) {
			return false;
		}
		//Example of a pattern:
		//1- 60 days High at i
		//2- i+1 and i+2 should be inside of i.high and i.low
		//3- Buy the day having higher high.  
		//4- Reverse for shorts
		for (int i = 60; i < mData.size()-6; i++){
			//go through mData bar by bar 
			//Do we have a patter at i
			int k = 0; //the day we buy the stock
			if((k = longPattern(i))>0 && (SixtyDaysH(i, 60)))
			{
				//compute the buyPrice 
				double buyPrice = mData.elementAt(i).High()+0.01;
				if(mData.elementAt(i+k).Open() > buyPrice)
				{
					i = i+k;
					continue;
				}
				double stopLoss = buyPrice*(1.0-mLoss);
				double target = buyPrice*(1.0+mTarget);
				//Create a trade 
				Trade T = new Trade(mSymbol, mData.elementAt(i+k).getDate(), 
						buyPrice, stopLoss, target, Direction.LONG);
				//check the outcome of the trade, and close it 
				outcomeLong(T, i+k);//check starting at index where we entered the trade
				//outcomeLong will close the trade
				//insert the trade into mTrades.
				mTrades.insert(T);
			}
			else if((k=shortPattern(i))>0&&(SixtyDaysL(i, 60)))
			{
				//compute the sellPrice 
				double sellPrice = mData.elementAt(i).Low()-0.01;
				if(mData.elementAt(i+k).Open() < sellPrice)
				{
					i = i+k;
					continue;
				}
			double stopLoss = sellPrice*(1.0 + mLoss);
			double target = sellPrice*(1.0 - mTarget);
			//Create a trade 
			Trade T = new Trade(mSymbol, mData.elementAt(i+k).getDate(), 
					sellPrice, stopLoss, target, Direction.SHORT);
			//check the outcome of the trade, and close it 
			outcomeShort(T, i+k);//check starting at index where we entered the trade
			//outcomeLong will close the trade
			//insert the trade into mTrades.
			mTrades.insert(T);
			}
		}
		return true;
	}
	private boolean load() { //HW for the break
		//build a file with path name using mPath and mSymbol
		
		String fileName = mPath+mSymbol+"_Daily.csv";//C:\ProfOmar286\Project\Data\BAC_Daily.csv
		// first String fileName = "C:/ProfOmar286/Data/" + "BAC" +"_Daily.csv";
		//check if the file exists (use FILE object)
		 File myfile = new File(fileName);
		 if (!myfile.exists()) {
			 System.out.println("file does not exist");
			 return false;
		 }
		 try {
			FileReader fr = new FileReader(fileName);
			//open the file FileReader->BufferedReader
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();//discard this line
			while((line=br.readLine()) != null) {
				Bar b =new Bar(line);
				mData.insert(b);
			}
			br.close();
			return true;
		 }catch(IOException e){
			 System.out.println(e.toString());
			 return false;
		 }
	}
}