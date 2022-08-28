
import java.util.HashMap;


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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> register;

    public VehicleRegistry() {
        this.register = new HashMap();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (!this.register.containsKey(licensePlate)) {
            this.register.put(licensePlate, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(LicensePlate licensePlate) {
        return this.register.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.register.containsKey(licensePlate)) {
            this.register.remove(licensePlate);
            return true;
        }
        
        return false;
    }
    
    public void printLicensePlates() {
        this.register.keySet().forEach(System.out::println);
    }
    
    public void printOwners() {
        this.register.values().stream().distinct().forEach(System.out::println);
    }
}
