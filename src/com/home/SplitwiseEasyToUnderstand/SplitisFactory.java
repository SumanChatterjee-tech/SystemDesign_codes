package com.home.SplitwiseEasyToUnderstand;

public class SplitisFactory {

    public static SplitStrategy getSplitFactory(SplitType splitType) throws Exception {
        switch (splitType){
            case EQUAL -> {
                return new EqualSplitStrategy();
            }
            default ->{
                throw new Exception("Invalid split strategy");
            }
        }
    }
}
