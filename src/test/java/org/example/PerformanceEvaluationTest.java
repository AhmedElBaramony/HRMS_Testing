package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PerformanceEvaluationTest {
    private PerformanceEvaluation performanceEvaluation;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Testing The PerformanceEvaluation Class");
    }

    @BeforeEach
    void setUp() {
        Evaluation quality = Evaluation.EXCELLENT;
        Evaluation productivity = Evaluation.GOOD;
        Evaluation punctuality = Evaluation.EXCELLENT;
        Evaluation collaboration = Evaluation.GOOD;
        Evaluation initiative = Evaluation.EXCELLENT;

        performanceEvaluation = new PerformanceEvaluation(quality, productivity, punctuality, collaboration, initiative);
    }

    @Test
    @DisplayName("Test Quality Getter/Setter")
    void testQuality() {
        assertEquals(Evaluation.EXCELLENT, performanceEvaluation.getQuality());
        performanceEvaluation.setQuality(Evaluation.GOOD);
        assertEquals(Evaluation.GOOD, performanceEvaluation.getQuality());
    }

    @Test
    @DisplayName("Test Productivity Getter/Setter")
    void testProductivity() {
        assertEquals(Evaluation.GOOD, performanceEvaluation.getProductivity());
        performanceEvaluation.setProductivity(Evaluation.EXCELLENT);
        assertEquals(Evaluation.EXCELLENT, performanceEvaluation.getProductivity());
    }

    @Test
    @DisplayName("Test Punctuality Getter/Setter")
    void testPunctuality() {
        assertEquals(Evaluation.EXCELLENT, performanceEvaluation.getPunctuality());
        performanceEvaluation.setPunctuality(Evaluation.FAIR);
        assertEquals(Evaluation.FAIR, performanceEvaluation.getPunctuality());
    }

    @Test
    @DisplayName("Test Collaboration Getter/Setter")
    void testCollaboration() {
        assertEquals(Evaluation.GOOD, performanceEvaluation.getCollaboration());
        performanceEvaluation.setCollaboration(Evaluation.EXCELLENT);
        assertEquals(Evaluation.EXCELLENT, performanceEvaluation.getCollaboration());
    }

    @Test
    @DisplayName("Test Initiative Getter/Setter")
    void testInitiative() {
        assertEquals(Evaluation.EXCELLENT, performanceEvaluation.getInitiative());
        performanceEvaluation.setInitiative(Evaluation.GOOD);
        assertEquals(Evaluation.GOOD, performanceEvaluation.getInitiative());
    }

    @Test
    @DisplayName("Test Evaluation Calculation")
    void testGetEvaluation() {
        assertEquals(Evaluation.GOOD, performanceEvaluation.getEvaluation());
        performanceEvaluation.setQuality(Evaluation.GOOD);
        performanceEvaluation.setProductivity(Evaluation.GOOD);
        performanceEvaluation.setPunctuality(Evaluation.FAIR);
        performanceEvaluation.setCollaboration(Evaluation.GOOD);
        performanceEvaluation.setInitiative(Evaluation.FAIR);

        assertEquals(Evaluation.FAIR, performanceEvaluation.getEvaluation());
    }
}
