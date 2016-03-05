/**
 * Created by fdiazaguirre on 3/4/16.
 */
function doubleLinkedTests () {}
registerTestSuite(doubleLinkedTests);

addTest(doubleLinkedTests, function previousTest() {
    // Given.
    var cities = new csWeb.DoubleLinked({value: 'NYC'}), expectedHead, expectedTail;

    // When.
    cities.append('SFO');
    expectedHead = cities.getHead();
    expectedTail = cities.getTail();

    // Then.
    expectEq(expectedHead, expectedTail.getPrev());
});

addTest(doubleLinkedTests, function searchTests () {
    // Given.
    var cities = new csWeb.DoubleLinked({value: 'NYC'}), head, newNode = new csWeb.Node('LAX');

    // When
    head = cities.find('NYC');
    cities.insertAfter(head, newNode);
    cities.append('SFO');

    // Then.
    expectEq(newNode, cities.find('LAX'));
    expectEq(head, newNode.getPrev());
});

addTest(doubleLinkedTests, function insertAfterTest() {
    // Given.
    var cities = new csWeb.DoubleLinked({value: 'NYC'}), head, newNode = new csWeb.Node('LAX');

    // When
    head = cities.find('NYC');
    cities.insertAfter(head, newNode);

    // Then.
    expectEq('NYC', head.getValue());
    expectEq(null, head.getPrev());
    expectEq(newNode, head.getNext());
    expectEq(head, newNode.getPrev());
});

addTest(doubleLinkedTests, function removeNodeWithValueTest () {
    // Given.
    var cities = new csWeb.DoubleLinked({value: 'NYC'}), middleNode, head, newNode = new csWeb.Node('LAX');

    // When
    head = cities.find('NYC');
    cities.insertAfter(head, newNode);
    cities.append('SFO');
    cities.remove('LAX');

    // Then.
    middleNode = cities.find('SFO');
    expectEq(head, middleNode.getPrev());
    expectEq(middleNode, head.getNext());
    expectEq(null, middleNode.getNext());
});

addTest(doubleLinkedTests, function backTest() {
    // Given.
    var head = csWeb.Node('NYC'),
        newNode = new csWeb.Node('LAX'),
        cities,
        actual;

    // When
    cities = new csWeb.DoubleLinked(head);
    cities.insertAfter(head, newNode);
    cities.append('SFO');
    cities.append('MIA');

    // Then.
    actual = cities.back(0);
    expectEq('MIA', actual.getValue());
    actual = cities.back(3);
    expectEq('NYC', actual.getValue());
});