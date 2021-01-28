package javaproject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// // SPACE COMPLEXITY FOR ALL CLASS =  O(N)
// TIME COMPLEXITY = 0(n)
public class EquipmentFile implements Serializable {
    private List<EquipmentFromFile> collection;

    public EquipmentFile(){
        collection = new ArrayList<EquipmentFromFile>();
    } //1

    public void addEquipmentToFile(EquipmentFromFile equipmentFromFile){ // 1
        collection.add(equipmentFromFile);

    }

    // TIME COMPLEXITY = 0(N)
    //SPACE COMPLEXITY = O(N)
    @Override
    public String toString(){
        String total = "\n";


        Iterator<EquipmentFromFile> i = collection.iterator();
        while (i.hasNext()){ //O(N) // O(N)
            EquipmentFromFile b = (EquipmentFromFile) i.next();
            total= total+b.toString();
        }
        return total;
    }
}
