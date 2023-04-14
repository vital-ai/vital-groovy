package ai.vital.vitalsigns.datatype;

public enum Truth {
    
    YES,
    NO,
    UNKNOWN,
    MU;
    
    public int asTruth() {
        
        if(this == YES) {
            return 1;
        } else if(this == NO) {
            return -1;
        } else if(this == UNKNOWN) {
            return 0;
        } else if(this == MU) {
            return 2;
        } else {
            throw new RuntimeException("Unhandled truth property value: " + this);
        }    
    }
    
    public static Truth fromBoolean(Boolean val) {
    	
        if(val == null) throw new RuntimeException("Truth boolean must not be null");
          
        return val.booleanValue() ? YES : NO;
    }
    
    public static Truth fromInteger(Integer val) {
        if(val == null) throw new RuntimeException("Truth integer must not be null");
        int i = val.intValue();
        if(i == 1) {
            return YES;
        } else if(i == -1) {
            return NO;
        } else if(i == 0) {
            return Truth.UNKNOWN;
        } else if(i == 2) {
            return Truth.MU;
        } else {
            throw new RuntimeException("Truth integer must be a value in [-1, 0, 1, 2]");
        }
    }
    
    public static Truth fromString(String s) {
        if(s == null) throw new RuntimeException("Truth string must not be null");
        return valueOf(s.toUpperCase());
    }
    
}