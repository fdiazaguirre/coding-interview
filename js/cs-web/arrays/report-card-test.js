/**
 * Created by fdiazaguirre on 2/15/16.
 */
function reportCardTests() {}
registerTestSuite(reportCardTests);

addTest(reportCardTests, function ReturnsCorrectValues() {
    // Given.
    var reportCard = csWeb.reportCard;
    var rc = reportCard({name: 'Fede'});

    // When.
    rc.addGrade(10);
    rc.addGrade(9);

    // Then.
    expectEq('Fede', rc.getName());
    expectEq(9.5, rc.getAvgGrade());
});