package com.supermartijn642.rechiseled.api.chiseling.conversion;
import com.supermartijn642.rechiseled.api.chiseling.ItemWithWorth;
public final class ChiselingConversionHelper {
    private ChiselingConversionHelper(){}
    public static ConversionResult convert(int inputCount,ItemWithWorth input,ItemWithWorth output){
        if(input==null||output==null||input.worth()<=0||output.worth()<=0)return new ConversionResult(0,inputCount);
        double converted=inputCount*input.worth()/output.worth();
        int result=(int)Math.floor(converted+1e-9);
        return new ConversionResult(result,Math.abs(converted-result)<1e-9?0:inputCount);
    }
}
