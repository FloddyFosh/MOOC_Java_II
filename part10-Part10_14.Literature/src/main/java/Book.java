
import java.util.Comparator;
import java.util.Objects;

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
public class Book implements Comparable<Book> {
    private final String name;
    private final int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + ageRecommendation + " year-olds or older)";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() == obj.getClass() ) {
            return false;
        }
        
        if (this == obj) {
            return true;
        }
        
        Book that = (Book) obj;
        
        return this.name.equals(that.name) && this.ageRecommendation == that.ageRecommendation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + this.ageRecommendation;
        return hash;
    }

    @Override
    public int compareTo(Book that) {
        return Comparator.comparing(Book::getAgeRecommendation).thenComparing(Book::getName).compare(this, that);
    }
    
}
