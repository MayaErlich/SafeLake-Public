package models;

import java.util.HashMap;
import java.util.List;

/**
 * Collection of Lake Pollution data
 *
 * <p>Contains collections for the different lakes that data will be stored for</p>
 * @author Tamim, Maya
 * */
public class LakeCollection extends HashMap<Lake, LakeData>{
    /**
     * Only constructor for the class
     * <p>Creates a {@link LakeData} object for each of the lakes found in {@link Lake}</p>
     * */
    public LakeCollection(){
        for(Lake lake : Lake.values()){
            this.put(lake, new LakeData(lake) );
        }
    }

    /**
     * Adds a row and sorts it into the correct object
     * 
     * @param row The row to add
     * @see LakeData#add(List) 
     */
    public void add(List<Object> row){
        this.get(Lake.getLake((String)row.get(0))).add(row);
        
    }
}
