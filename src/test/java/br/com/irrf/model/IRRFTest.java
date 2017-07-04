/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrf.model;

import br.com.irrfweb.model.Calculo;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renan
 */
public class IRRFTest {

    GregorianCalendar gc = new GregorianCalendar();
    Date data = gc.getTime();

    public IRRFTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValor1 method, of class Calculo.
     */
    //                              Teste 1
    @Test
    public void testGetValor1() {
        Calculo calc = new Calculo(60, "João", data, 3.14, 56789.56, 2, 1500.0, 23456.0, 24354.0, 34256.0);
        double resultadoEsperado = 144905.72;
        double resultado = calc.deducoes();
        assertEquals(resultadoEsperado, resultado, 0.0);
    }

    //                              Teste 2
    @Test
    public void testeCasoTeste02() {
        Calculo calc = new Calculo(10, "Jorge", data, 2.3, 23.34, 1, 2132.13, 12.12, 1122.23, 12312.1);
        double resultadoEsperado = 17877.00;
        double resultado = calc.deducoes();
        assertEquals(resultadoEsperado, resultado, 0.0);
    }

    //                              Teste 3
    @Test
    public void testeCasoTeste03() {
        Calculo calc = new Calculo(80, "Jorgina", data, 2343.14, 5678.56, 4, 15000.0, 3456.0, 354.0, 346.0);
        double resultadoEsperado = 33934.88;
        double resultado = calc.deducoes();
        assertEquals(resultadoEsperado, resultado, 0.0);
    }

    //                              Teste 4
    @Test
    //teste caso em branco
    public void testeCasoTeste04() {
        Calculo calc = new Calculo(213, "", null, 0.00, 0.00, 0, 0.00, 0.00, 0.00, 0.00);
        double resultadoEsperado = 0.00;
        double resultado = calc.deducoes();
        assertEquals(resultadoEsperado, resultado, 0.0);
    }
}
