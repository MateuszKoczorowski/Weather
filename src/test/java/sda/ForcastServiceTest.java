package sda;

import org.junit.jupiter.api.Test;

public class ForcastServiceTest {

    @Test
    public void test() {
        LocationRepositoryMock locationRepositoryMock = new LocationRepositoryMock();
        locationRepositoryMock.save(new Location(1, "Bydgoszcz", 53.1,18.0, "kujawsko-pomorskie ", "Poland"));
        ForecastService forecastService = new ForecastService(locationRepositoryMock);
        Forecast forecast = forecastService.getForecast(1L, 1);
        System.out.println(forecast);
    }
}

