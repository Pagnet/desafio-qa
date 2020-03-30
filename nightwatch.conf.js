const chromedriver = require('chromedriver');

module.exports = {
    src_folders: ["steps"], //pasta com os steps definitions
    page_objects_path: 'pages/', //pasta com os seletores da página
    test_settings: {
        default: {
            skip_testcases_on_fail: false,
            screenshots: {
                enabled: true,
                path: 'screenshots'
            },
            launch_url: 'https://desafio-qa.herokuapp.com/',
            webdriver: {
                start_process: true,
                server_path: chromedriver.path,
                port: 9515
            },
            desiredCapabilities: {
                browserName: 'chrome'
            }
        }
    }
};