
import java.util.ArrayList;
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
public class ShoppingCart {
    private List<Item> products;

    public ShoppingCart() {
        this.products = new ArrayList();
    }
    
    public void add(String product, int price) {
        Item i = new Item(product, 1, price);
        if (products.contains(i)) {
            products.get(products.indexOf(i)).increaseQuantity();
        } else {
            products.add(i);
        }
    }
    
    public int price() {
        return products.stream().mapToInt(p -> p.price()).sum();
    }
    
    public void print() {
        products.forEach(System.out::println);
    }
}
