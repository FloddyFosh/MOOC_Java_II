
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public void print() {
        cards.stream().forEach(System.out::println);
    }
    
    public int value() {
        return cards.stream().mapToInt(c -> c.getValue()).sum();
    }
    
    public void sortBySuit() {
        cards.sort(new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand that) {
        return this.value() - that.value();
    }
}
