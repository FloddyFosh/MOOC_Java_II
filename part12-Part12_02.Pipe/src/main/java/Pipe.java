
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
public class Pipe<T> {
    private List<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList();
    }
    
    public void putIntoPipe(T value) {
        pipe.add(value);
    }
    
    public T takeFromPipe() {
        return pipe.remove(0);
    }
    
    public boolean isInPipe() {
        return !pipe.isEmpty();
    }
}
