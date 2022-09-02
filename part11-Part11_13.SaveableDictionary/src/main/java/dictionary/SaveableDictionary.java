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
package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Chris Bakker
 */
public class SaveableDictionary {
    private Map<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }
    
    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");   // split the line based on the ':' character
                add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean save() {
        try (PrintWriter writer = new PrintWriter(file)) {
            dictionary.entrySet().forEach(e -> writer.println(e.getKey() + ":" + e.getValue()));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public void add(String words, String translation) {
        dictionary.putIfAbsent(words, translation);
    }
    
    public void delete(String word) {
        dictionary.entrySet().removeIf(e -> e.getKey().equals(word) || e.getValue().equals(word));
    }
    
    public String translate(String word) {
        String translation = dictionary.get(word);
        if (translation == null) {
            translation = dictionary.entrySet().stream().filter(e -> e.getValue().equals(word)).map(k -> k.getKey()).findAny().orElse(null);
        }
        return translation;
    }
}
