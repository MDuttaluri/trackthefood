package com.inhouse.trackthefood.Helpers;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UserHelper {
    public HashMap<String, Object> calculateBMI(int age, float height, float weight){
        /* weight / height ** 2 x  703 */

        height = height / 100;  // cm to m
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        float bmi = (float)(weight / Math.pow(height, 2)); 
        returnMap.put("BMI", bmi);

        if (bmi < 18.4) {
            returnMap.put("label", "Underweight");    
        } else if (bmi < 25) {
            returnMap.put("label", "Normal weight");
        } else if (bmi < 30) {
            returnMap.put("label", "Over weight");
        } else{
            returnMap.put("label", "Obese");
        }

        return returnMap;
        
    }
    
    public int calculateBMR(int age, float height, float weight){
        /* 66.4730 + 13.7516 x weight in kg + 5.0033 x height in cm – 6.7550 x age */
        return  (int)(66.4730 + 13.7516 * weight + 5.0033 * height - 6.7550 * age);
    }

}
