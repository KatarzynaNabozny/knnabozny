package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectorTestSuite {

    @DisplayName("should add figure")
    @Test
    void addFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(6);
        String expectedShapeName = "Circle";
        //when
        shapeCollector.addFigure(circle);
        //then
        Assertions.assertEquals(expectedShapeName, shapeCollector.getFigure(0).getShapeName());
    }

    @DisplayName("should remove figure")
    @Test
    void removeFigure() {
        //given
        Circle circle = new Circle(6);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(circle);
        String expectedEmptyString = "[]";
        //when
        shapeCollector.removeFigure(circle);
        //then
        Assertions.assertEquals(expectedEmptyString, shapeCollector.showFigures());
    }

    @DisplayName("Should get specific figure")
    @Test
    void getFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(6);
        shapeCollector.addFigure(circle);
        String expectedShapeName = "Circle";
        //when
        Shape resultFigure = shapeCollector.getFigure(0);
        //then
        Assertions.assertEquals(expectedShapeName, resultFigure.getShapeName());
    }

    @DisplayName("should display Shape with filed")
    @Nested
    class Other{
        @Test
        void showFigures() {
            //given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(6);
            shapeCollector.addFigure(circle);
            String expectedFigures = "[Circle{radius=6.0}]";
            //when
            String resultFigure = shapeCollector.showFigures();
            //then
            Assertions.assertEquals(expectedFigures, resultFigure);
        }
    }


}