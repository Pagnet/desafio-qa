require('babel-core/register')
const chromedriver = require('chromedriver')

const testUrl = 'http://automationpractice.com/index.php';
const defaultTimeout = 15000;

module.exports = {
  src_folders: ['tests_end_to_end/'],

  page_objects_path: './pages',
  globals_path: './hooks/globals.js',

  webdriver: {
    start_process: true,
    server_path: chromedriver.path,
    port: 9515
  },

  test_settings: {
    default: {
      launch_url: testUrl,
      globals: {
        waitForConditionTimeout: defaultTimeout
      },
      desiredCapabilities: {
        browserName: "chrome",
        /*
        chromeOptions: {
          binary: 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe',
        },*/
      }
    }
  }
}
