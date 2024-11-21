package com.foodorder.other;

import com.foodorder.models.User;
import org.springframework.stereotype.Component;

@Component
public class OtherDependency {
        public boolean isValidUser(User user) {
            // Implementation logic here
            return true;  // Example implementation
        }
    }




