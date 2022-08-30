
import java.util.ArrayList;

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
public class Box implements Packable {
    private final double capacity;
    private ArrayList<Packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList();
    }

    private double howMuchSpaceLeft() {
        return capacity - weight();
    }
    
    public void add(Packable p) {
        if(p.weight() <= howMuchSpaceLeft()) {
            items.add(p);
        }
    }
    
    @Override
    public double weight() {
        return items.stream().mapToDouble(i -> i.weight()).sum();
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
    
    
}
