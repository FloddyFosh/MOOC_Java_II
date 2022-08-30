
import java.util.ArrayList;
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
public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    public double maxValue() {
        return this.history.stream().max(Double::compare).orElse(0.0);
    }
    
    public double minValue() {
        return this.history.stream().min(Double::compare).orElse(0.0);
    }
    
    public double average() {
        return this.history.stream().collect(Collectors.averagingDouble(d -> d));
    }

    @Override
    public String toString() {
        return this.history.toString();
    }
    
    
}
