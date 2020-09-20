let chai = require('chai');
let chaiHttp = require('chai-http');
let should = chai.should();
chai.use(chaiHttp);
const request = chai.request("http://automationpractice.com/index.php")
const expect = chai.expect;
let temp = '';

describe('Testes de Login', () => {

  it('Login com sucesso', (done) => {

    request
      .get(`?controller=authentication&email=mbn.man@gmail.com&passwd=12345&back=my-account&SubmitLogin`)
      .set('Cookie', 'PrestaShop-a30a9934ef476d11b6cc3c983616e364=PogbNc82M5pfxrDr6mKBPFC75Ud9wfrp2Mop89mkMS479%2B0IFvuLh%2Fi6ek6tXOmkZVdfBRztgn6VrVLEQYAmSglqLIsQ60hfaaOduLbZDpux9G8%2B4pKtn6UCnsNEQnlHjcA6JLNQmx5fL%2BwZ9cI%2BXEtCRmiKl9851UGBjD9jDcpHl0%2BQkl4%2FTWvAEcm%2BuZ2%2FnA2dbFRgcadJ5gFWpNpliyXxWd8RqUefPEDCKjN4ETsQAUoLWESntUTUKZusp%2BuKyY28XWtk9XkkRkVHNfB1KuoXYqwjNFOS71wF0ysB%2B%2B8ozSEDyAwqI6%2FoukW9X8E1hzkP406ZeAQW1XT%2BPWHpM9wP5gH9zmEUTh5cvRTkAXNsKaDIloLyYvbr%2FZ5eBlM1e9x2Bs3LLNHntYox0nWYBYcH7SuNcCAGOjNPRD1Zl6s%3D000307')
      .end((err, res) => {

        res.should.have.status(200);
        var result = JSON.stringify(res)

        //faz split do json em array por ","
        var splitedResult = result.split(",")

        //linha que será buscada
        var search = 'static_token'

        for (const index in splitedResult) {

          // busca string dentro do json convertido em array
          if (splitedResult[index].indexOf(search) > -1) {

            //converte array encontrado com contéudo em string
            var stringResult = splitedResult[index].toString()

            //faz split da string por ";" 
            temp = stringResult.split(";")[32]
            break
          }
        }

        //e pega o token do usuário 
        static_token = temp.toString().substr(22, 32)
        expect(static_token).to.equals("48824c3fdfbd05de0f8ac181697f37c0");

        done();

      });
  });
});
