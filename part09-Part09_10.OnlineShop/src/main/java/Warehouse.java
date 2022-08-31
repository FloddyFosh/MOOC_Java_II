
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class Warehouse {
    private Map<String, Integer> productStock;
    private Map<String, Integer> productPrice;

    public Warehouse() {
        this.productStock = new HashMap();
        this.productPrice = new HashMap();
    }
    
    public void addProduct(String product, int price, int stock) {
        productPrice.put(product, price);
        productStock.put(product, stock);
    }
    
    public int price(String product) {
        return productPrice.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return productStock.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        if (productStock.getOrDefault(product, 0) > 0) {
            productStock.replace(product, productStock.get(product)-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return productPrice.keySet();
    }
    
}
