package com.example.demo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestKnapsackProblem {
    @Test
    void testRepeatedElement() {
        var element1 = new Element(5,10);
        var element2 = new Element(5,10);
        var knapsack = new Knapsack(30,2);
        knapsack.addElement(element1);
        assertTrue(knapsack.existElement(element2));
    }
    @Test
    void testDeleteElement(){
        var element1 = new Element(5,10);
        var element2 = new Element(4,8);
        var knapsack = new Knapsack(30,2);
        knapsack.addElement(element1);
        knapsack.addElement(element2);
        knapsack.deleteElement(element2);
        assertFalse(knapsack.existElement(element2));
    }
}
