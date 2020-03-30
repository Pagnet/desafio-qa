const {client} = require('nightwatch-api')
const {Given, When, Then} = require('cucumber')
const fs = require('fs');
const path = require('path');
const tmp = require('tmp');


const { compare, imagePath } = require(`../helpers/image-diff`);
// Este é o diretório (temporário) onde salvamos o
// screenshot da representação atual da página.
const currentDirectory = tmp.dirSync().name;
// Screenshot de referência é salvo nesse diretório
// Esta página deve ser adicionada no repósitório
const referenceDirectory = path.resolve(__dirname, `..`, `visual-reference`);


Then('Eu pego screenshot da pagina {string}', function (name) {
  const referenceRun = process.argv.includes(`visual-regression-reference`);

  const currentImage = imagePath({ base: currentDirectory, name });
  const referenceImage = imagePath({ base: referenceDirectory, name });

  // Se não tiver imagem de referência ela é criada
  if (referenceRun || !fs.existsSync(referenceImage)) {
    // eslint-disable-next-line no-console
    console.info(`INFO: Reference image successfully created: ${referenceImage}`);
    client.saveScreenshot(referenceImage);
  }

  return client.saveScreenshot(currentImage);
});

Then('Eu espero a página de {string} ter o mesmo layout', async function(name) {
  const currentImage = imagePath({ base: currentDirectory, name });
  const referenceImage = imagePath({ base: referenceDirectory, name });

  // Se a comparação da imagem der OK o teste passa, senão falha.
  return compare({ currentImage, name, referenceImage });
});
