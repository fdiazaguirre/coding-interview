/**
 * Created by fdiazaguirre on 2/20/16.
 */
function weatherRepoTests () {}
registerTestSuite(weatherRepoTests);

addTest(weatherRepoTests, function addTest() {
    // Given.
    var repo = csWeb.weeklyWeatherRepo();

    // When.
    repo.add(1,1,35);

    // Then.
    expectEq(35, repo.weekAvg(1,1));
});

addTest(weatherRepoTests, function weekAvgTest() {
    // Given.
    var repo = csWeb.weeklyWeatherRepo();

    // When.
    repo.add(1,1,29);
    repo.add(1,1,31);
    repo.add(1,1,30);

    // Then.
    expectTrue(repo.hasToCompute(1,1));
    expectEq(30, repo.weekAvg(1,1));
    expectFalse(repo.hasToCompute(1,1));
});

addTest(weatherRepoTests, function monthAvgTest() {
    // Given.
    var repo = csWeb.weeklyWeatherRepo();

    // When.
    repo.add(1,1,29);
    repo.add(1,2,31);
    repo.add(1,3,32);
    repo.add(1,3,28);
    repo.add(1,4,27);

    // Then.
    expectEq(undefined, repo.getMonthMemo()[0]);
    // result = (29 + 31 + (32 + 28) / 2 + 27) / 4
    expectEq(29.25, repo.monthAvg(1));
    // Memo now is defined.
    expectEq(29.25, repo.getMonthMemo()[0]);
});

addTest(weatherRepoTests, function yearAvgTest() {
    // Given.
    var repo = csWeb.weeklyWeatherRepo();

    // When.
    repo.add(1,1,-35);
    repo.add(2,1,-10);
    repo.add(3,1,15);
    repo.add(4,1,20);
    repo.add(5,1,25);
    repo.add(6,1,35);
    repo.add(7,1,45);
    repo.add(8,1,55);
    repo.add(9,1,65);
    repo.add(10,1,55);
    repo.add(11,1,-5);
    repo.add(12,1,-25);

    // Then.
    expectEq(20, repo.yearAvg());
});