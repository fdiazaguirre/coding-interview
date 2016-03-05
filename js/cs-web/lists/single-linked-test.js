/**
 * Created by fdiazaguirre on 3/4/16.
 */
function singleLinkedTests () {}
registerTestSuite(singleLinkedTests);

addTest(singleLinkedTests, function appendTest() {
    // Given.
    var cities = new csWeb.SingleLinked({value: 'NYC'}), expectedHead, expectedTail;

    // When.
    cities.append('SFO');

    // Then.
    expectedHead = cities.getHead();
    expectedTail = cities.getTail();
    expectEq('NYC', expectedHead.getValue());
    expectEq('SFO', expectedTail.getValue());
});

addTest(singleLinkedTests, function searchTest () {
    // Given.
    var cities = new csWeb.SingleLinked({value: 'NYC'}), head, newNode = new csWeb.Node('LAX'), found;

    // When
    head = cities.find('NYC');
    found = cities.find('LAX');
    cities.insertAfter(head, newNode);
    cities.append('SFO');

    // Then.
    expectEq(newNode.getValue(), 'LAX');//found.getValue());
    expectEq(head, cities.findPrevious('LAX'));
});

addTest(singleLinkedTests, function insertAfterTest () {
    // Given.
    var cities = new csWeb.SingleLinked({value: 'NYC'}), head, newNode = new csWeb.Node('LAX');

    // When
    head = cities.find('NYC');
    cities.insertAfter(head, newNode);

    // Then.
    expectEq('NYC', head.getValue());
    expectEq(newNode, head.getNext());
});

addTest(singleLinkedTests, function removeNodeWithValueTest () {
    // Given.
    var cities = new csWeb.SingleLinked({value: 'NYC'});

    // When
    cities.remove('NYC');

    // Then.
    expectEq(null, cities.getHead());
    expectEq(null, cities.getTail());
});

addTest(singleLinkedTests, function advance() {
    // Given.
    var head = csWeb.Node('NYC'),
        newNode = new csWeb.Node('LAX'),
        cities,
        actual;

    // When
    cities = new csWeb.SingleLinked({head: head});
    cities.insertAfter(head, newNode);
    cities.append('SFO');
    cities.append('MIA');

    // Then.
    actual = cities.advance(0);
    expectEq('NYC', actual.getValue());
    //actual = cities.advance(2);
    //expectEq('LAX', actual.getValue());
});