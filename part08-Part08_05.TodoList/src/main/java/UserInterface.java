
import java.util.Scanner;

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
public class UserInterface {
    private TodoList todo;
    private Scanner scanner;

    public UserInterface(TodoList todo, Scanner scanner) {
        this.todo = todo;
        this.scanner = scanner;
    }
    
    public void start() {
        
        String cmd, task;
        do {
            System.out.println("Command: ");
            cmd = scanner.nextLine();
            
            switch (cmd) {
                case "stop":
                    break;
                case "add":
                    System.out.println("To add: ");
                    task = scanner.nextLine();
                    
                    todo.add(task);
                    break;
                case "list":
                    todo.print();
                    break;
                case "remove":
                    System.out.println("Which one is removed? ");
                    todo.remove(Integer.parseInt(scanner.nextLine()));
                default:
                    System.out.println("Unknown command");
            }
            
        } while (!cmd.equals("stop"));
        
    }
}
