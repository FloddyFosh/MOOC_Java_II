
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/*
 * Copyright 2022 Chris Bakker.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 * @author Chris Bakker
 */
public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;

    public StorageFacility() {
        this.units = new HashMap();
    }
    
    public void add(String unit, String item) {
        this.units.putIfAbsent(unit, new ArrayList());
        this.units.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit) {
        return this.units.getOrDefault(storageUnit, new ArrayList());
    }
    
    public void remove(String storageUnit, String item) {
        if (this.units.containsKey(storageUnit)) {
            ArrayList<String> items = this.units.get(storageUnit);
            if (items == null || items.isEmpty()) {
                this.units.remove(storageUnit);
            } else {
                items.remove(item);
            }
        }
    }
    
    public ArrayList<String> storageUnits() {
        return this.units.entrySet().stream().filter(u -> !u.getValue().isEmpty()).map(v -> v.getKey()).collect(Collectors.toCollection(ArrayList::new));
    }
}
