'use strict';

describe('Moving blocks', function() {


  it('should automatically redirect to /block when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("block");
  });


  describe('Block view', function() {
    beforeEach(function() {
      browser.get('#/block');
    });


    it('should move blocks around', function() {
      var input = element(by.model('input'));
      input.sendKeys("3\nmove 0 to 1\nmove 2 to 0");

      var submit = element(by.buttonText("Submit"));
      submit.click();
      browser.waitForAngular();

      var output = element(by.model('output'));
      expect(output.getText()).toMatch("0->2\n1->1,0\n2->");
    });

  });

});
