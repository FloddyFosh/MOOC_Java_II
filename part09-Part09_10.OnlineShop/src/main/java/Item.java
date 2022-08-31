
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
public class Item {
    private String name;
    private int quantity;
    private int unitPrice;
    
    public Item(String product, int qty, int unitPrice) {
        this.name = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return quantity * unitPrice;
    }
    
    public void increaseQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return name + ": " + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        if(obj == this) {
            return true;
        }
        
        Item compared = (Item) obj;
        
        return this.name.equals(compared.name) && this.unitPrice == compared.unitPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.unitPrice;
        return hash;
    }

    
}
