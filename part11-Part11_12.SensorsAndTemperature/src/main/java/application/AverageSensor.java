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
package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Chris Bakker
 */
public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList();
        this.readings = new LinkedList();
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return sensors.stream().allMatch(s -> s.isOn() == true);
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(s -> s.setOn());
    }

    @Override
    public void setOff() {
        sensors.get(new Random().nextInt(sensors.size())).setOff();
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) throw new IllegalStateException("The sensor is not On or no sensors are added.");
        Integer reading = (int) sensors.stream().mapToInt(s -> s.read()).average().orElse(0);
        readings.add(reading);
        return reading;
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
}
