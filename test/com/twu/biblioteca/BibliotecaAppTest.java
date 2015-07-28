package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class BibliotecaAppTest {

    @Test
    public void bibliotecaAppShouldAbleToRun() {
        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu);

        assertEquals(true, bibliotecaApp.run());
    }

    @Test
    public void applicationKnowsHowToDisplayWelcomeMessage() {
        BibliotecaApp bibliotecaApp = Mockito.mock(BibliotecaApp.class);

        bibliotecaApp.run();

        Mockito.verify(bibliotecaApp).run();
    }
}