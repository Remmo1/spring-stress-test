package com.example.bookstore;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.OpenInjectionStep.RampRate.RampRateOpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class BookSaveSimulation extends Simulation {

    // Test 1: Normal conditions
    OpenInjectionStep[] firstOpenInjectionSteps = {
            rampUsersPerSec(5)                      // Start at 5 users/sec
                    .to(100)                        // Increase to 100 users/sec
                    .during(Duration.ofSeconds(120)),  // Ramp-up in 2 min
            constantUsersPerSec(100)                // Hold at 100 users/sec
                    .during(600)                    // Keep it for 10 minutes
    };

    // Test 2: Spike test
    OpenInjectionStep[] secondOpenInjectionSteps = {
            rampUsersPerSec(10)
                    .to(200)
                    .during(Duration.ofSeconds(60)),
            constantUsersPerSec(200)
                    .during(300)
    };

    // Test 3: Long term test
    OpenInjectionStep[] thirdOpenInjectionSteps = {
            rampUsersPerSec(2)
                    .to(50)
                    .during(Duration.ofSeconds(180)),
            constantUsersPerSec(50)
                    .during(1200)
    };

    public BookSaveSimulation() {

        setUp(buildPostScenario()
                .injectOpen(
                        firstOpenInjectionSteps
                )
                .protocols(setupProtocol())).assertions(global().responseTime()
                .max()
                .lte(10000), global().successfulRequests()
                .percent()
                .gt(90d));
    }

    private static ScenarioBuilder buildPostScenario() {
        return CoreDsl.scenario("Load POST Test")
                .feed(feedData())
                .exec(http("create-book").post("/store/book")
                        .header("Content-Type", "application/json")
                        .body(StringBody("{ \"title\": \"${title}\",\n\"author\": \"${author}\" }")));
    }


    private static Iterator<Map<String, Object>> feedData() {
        Faker faker = new Faker();
        Iterator<Map<String, Object>> iterator;
        iterator = Stream.generate(() -> {
                    Map<String, Object> stringObjectMap = new HashMap<>();
                    stringObjectMap.put("title", faker.book().title());
                    stringObjectMap.put("author", faker.book().author());
                    return stringObjectMap;
                })
                .iterator();
        return iterator;
    }

    private static HttpProtocolBuilder setupProtocol() {
        return HttpDsl.http.baseUrl("http://localhost:8080")
                .acceptHeader("application/json")
                .header("Authorization", "example-token")
                .maxConnectionsPerHost(10)
                .userAgentHeader("Performance Test");
    }

}