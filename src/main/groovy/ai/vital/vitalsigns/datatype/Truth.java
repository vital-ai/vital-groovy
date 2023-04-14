/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

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