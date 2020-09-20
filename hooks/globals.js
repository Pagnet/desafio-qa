module.exports = {
    beforeEach: (browser, done) => {
        browser.maximizeWindow()
        done()
    },

    afterEach: (browser, done) => {

        const fake = require('faker')

        let shopPath = `./tests_output/screenshots/${fake.random.uuid()}.png`

        browser
            .saveScreenshot(shopPath, function () {
                const assertions = browser.currentTest.results.assertions || [];
                if (assertions.length > 0) {
                    const currentAssertion = assertions[assertions.length - 1];
                    if (currentAssertion) {
                        currentAssertion.screenshots = currentAssertion.screenshots || [];
                        currentAssertion.screenshots.push(shopPath);
                    }
                }
            })
            .end();

        done()
    },
}