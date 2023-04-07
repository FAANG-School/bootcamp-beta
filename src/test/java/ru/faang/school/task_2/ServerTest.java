package ru.faang.school.task_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServerTest {
    Server testServer;

    @ParameterizedTest
    @ValueSource(doubles = {19.99, 1000.99, -1.0})
    public void server_PassedTooLittleOrTooMuchMaxLoad_expectedThrowsIllegalArgumentException(double maxLoad) {
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> new Server(maxLoad));
        assertEquals("The server is too weak or too powerful.", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {21, 100, 999})
    public void server_PassedValidMaxLoad_ServerCreatedCorrectly(double maxLoad) {
        double expectedLoad = 0.0d;
        double expectedEnergyConsumption = 0.0d;
        testServer = new Server(maxLoad);
        assertEquals(maxLoad, testServer.getMaxLoad());
        assertEquals(expectedLoad, testServer.getLoad());
        assertEquals(expectedEnergyConsumption, testServer.getEnergyConsumption());
    }

    @Test
    public void getPossibleLoadAndGetMaxLoad_ExpectCorrectResult(){
        testServer = new Server(150d);
        assertEquals(150d, testServer.getPossibleLoad());
        assertEquals(150d, testServer.getMaxLoad());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.9, 101})
    public void addLoadTheServer_PassedTooMuchLoad_expectedThrowsIllegalArgumentException() {
        testServer = new Server(100);
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> testServer.addLoadTheServer(101));
        assertEquals("Too much load on the server.", ex.getMessage());
    }

    @Test
    public void addLoadTheServer_PassedCorrectLoad_loadIsSettedCorrectly() {
        double expectedLoad = 10;
        double expectedEnergyConsumption = 50;
        double expectedMaxLoad = 100;
        testServer = new Server(100);
        testServer.addLoadTheServer(10);
        assertEquals(expectedLoad, testServer.getLoad());
        assertEquals(expectedEnergyConsumption, testServer.getEnergyConsumption());
        assertEquals(expectedMaxLoad, testServer.getMaxLoad());
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 10.0, 50.0, 0.0",
            "10.0, 0.0, 0.0, 0.0",
            "100.0, 0.0, 0.0, 90.0",
    })
    public void relieveLoadOnServer_passedCorrectLoad_expectedLoadRemovedCorrectly(double load, double expectedLoad, double expectedEnergyConsumption, double expectedReturnedValue) {
        testServer = new Server(100);
        testServer.setLoad(10);
        testServer.setEnergyConsumption(50);
        double returnedValue = testServer.relieveLoadOnServer(load);
        assertEquals(expectedLoad, testServer.getLoad());
        assertEquals(expectedEnergyConsumption, testServer.getEnergyConsumption());
        assertEquals(returnedValue, expectedReturnedValue);
    }

    @Test
    public void relieveLoadOnServer_passedNegativeNumber_expectedIllegalArgumentException() {
        testServer = new Server(100);
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> testServer.relieveLoadOnServer(-1));
        assertEquals("The load cannot be negative.", ex.getMessage());
    }

    @Test
    public void unloadServer_expectParametersToBeSetToZero(){
        testServer = new Server(100);
        testServer.setLoad(10);
        testServer.setEnergyConsumption(50);
        testServer.unloadServer();
        assertEquals(0.0, testServer.getLoad());
        assertEquals(0.0, testServer.getEnergyConsumption());
    }

    @Test
    public void isEmpty_expectTrueIfLoadIsZeroOtherwiseFalse(){
        testServer = new Server(100);
        assertEquals(true, testServer.isEmpty());
        testServer.setLoad(10);
        assertEquals(false, testServer.isEmpty());
    }

}
