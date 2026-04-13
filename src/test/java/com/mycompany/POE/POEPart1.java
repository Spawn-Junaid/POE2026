/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class POEPart1 {

    public POEPart1() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Runs once before any tests start
    }

    @AfterAll
    public static void tearDownClass() {
        // Runs once after all tests finish
    }

    @BeforeEach
    public void setUp() {
        // Runs before EACH test method
    }

    @AfterEach
    public void tearDown() {
        // Runs after EACH test method
    }

  @Test
    public void testUsernameFormatting() {
        POE.Login login = new POE.Login("Junaid", "Spawn", "Kyl_1", "Password123!", "000");
        assertTrue(login.checkUserName(), "Username should be valid (contains _ and <= 5 chars)");
    }
    
    @Test
    public void testPasswordComplexity() {
      POE.Login login = new POE.Login("Junaid", "Spawn", "Kyl_l", "Ch&&sec@ke99!", "000");
        assertTrue(login.checkPasswordComplexity(), "Password should meet all complexity requirements");
    }
}

