
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
public class Abbreviations {

    HashMap<String, String> abbs;
    
    public Abbreviations() {
        abbs = new HashMap();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        abbs.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return abbs.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return abbs.get(abbreviation);
    }
}
