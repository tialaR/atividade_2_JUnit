package br.ucsal.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.ucsal.business.Primo;

@RunWith(Parameterized.class)
public class PrimoTest {
	
	public static class Teste {
		private final int input;
        private final boolean expected;
        private Primo primo;
	
        public Teste(int input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }
        
        @Before
        public void inicializar(){
            primo = new Primo();
        }
        
        @Parameters
        public static Collection automatedTesting() {
            return Arrays.asList(new Object[][] {{23, true}, {24, false}, {29, true}, {30, false},
                    {31, true}, {32, false}, {37, true}, {38, false}, {41, true}, {292, false}});
        }
        
        
        @Test
        public void out() {
            System.out.print("Número digitaddo" + input);
            assertEquals("Expectativa: ", primo.ehPrimo(input));
        }
	}
	
	public static class InputOutput {
		@Test
        public void inputTest(){
            ByteArrayInputStream inputContent = new ByteArrayInputStream("13".getBytes());
            System.setIn(inputContent);
            Primo primo = new Primo();
            assertEquals(false, primo.ehPrimo(primo.solicitaNumero()));
        }

        @Test
        public void inputTestTwo(){
            ByteArrayInputStream inputContent = new ByteArrayInputStream("14".getBytes());
            System.setIn(inputContent);
            Primo primo = new Primo();
            assertEquals(true, primo.ehPrimo(primo.solicitaNumero()));
        }
        
        @Test
        public void inputTestTree(){
            ByteArrayInputStream inputContent = new ByteArrayInputStream("19".getBytes());
            System.setIn(inputContent);
            Primo primo = new Primo();
            assertEquals(true, primo.ehPrimo(primo.solicitaNumero()));
        }

        @Test
        public void outputTest(){
            ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputContent));

            Primo primo = new Primo();
            primo.ehPrimo(12);
            String result = outputContent.toString();

            String expectedResult = "12 não é um n. primo.";
            assertEquals( expectedResult, result);
        }

        @Test
        public void outputTestTwo(){
            ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputContent));

            Primo primo = new Primo();
            primo.isPrimo(101);
            String result = outputContent.toString();

            String expectedResult = "101 é um n. primo.";
            assertEquals(expectedResult, result);
        }
        
        @Test
        public void outputTestTree(){
            ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputContent));

            Primo primo = new Primo();
            primo.isPrimo(101);
            String result = outputContent.toString();

            String expectedResult = "97 é um n. primo.";
            assertEquals(expectedResult, result);
        }
	}
	

}
