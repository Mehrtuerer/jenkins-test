package com.example.JenkinsTest;
import org.springframework.stereotype.Service;

 /**
  * The Base Calculator class.
  */
@Service
public class Calculator {
     int sum(int a, int b) {
          return a + b;
     }
}

