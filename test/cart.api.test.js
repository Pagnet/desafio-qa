let chai = require('chai');
let chaiHttp = require('chai-http');
let should = chai.should();
chai.use(chaiHttp);
const request = chai.request("http://automationpractice.com/index.php")
const expect = chai.expect;
let temp = '';

describe('Testes do Carrinho', () => {

    it('Adicionar item no carrinho', (done) => {

        var product = {
            name: 'Blouse',
        }

        request
            .post(`?controller=cart&add=1&ajax=true&qty=1&id_product=2&token=48824c3fdfbd05de0f8ac181697f37c0`)
            .set('Cookie', 'PrestaShop-a30a9934ef476d11b6cc3c983616e364=PogbNc82M5pfxrDr6mKBPFC75Ud9wfrp2Mop89mkMS479%2B0IFvuLh%2Fi6ek6tXOmkZVdfBRztgn6VrVLEQYAmSglqLIsQ60hfaaOduLbZDpux9G8%2B4pKtn6UCnsNEQnlHjcA6JLNQmx5fL%2BwZ9cI%2BXEtCRmiKl9851UGBjD9jDcpHl0%2BQkl4%2FTWvAEcm%2BuZ2%2FnA2dbFRgcadJ5gFWpNpliyXxWd8RqUefPEDCKjN4ETsQAUoLWESntUTUKZusp%2BuKyY28XWtk9XkkRkVHNfB1KuoXYqwjNFOS71wF0ysB%2B%2B8ozSEDyAwqI6%2FoukW9X8E1hzkP406ZeAQW1XT%2BPWHpM9wP5gH9zmEUTh5cvRTkAXNsKaDIloLyYvbr%2FZ5eBlM1e9x2Bs3LLNHntYox0nWYBYcH7SuNcCAGOjNPRD1Zl6s%3D000307')
            .send()
            .end((err, res) => {

                res.should.have.status(200);
                var result = JSON.stringify(res)
        
                //faz split do json em array por ","
                var splitedResult = result.split(":")
        
                //linha que será buscada
                var search = product.name
        
                for (const index in splitedResult) {
        
                  // busca string dentro do json convertido em array
                  if (splitedResult[index].indexOf(search) > -1) {
        
                    //converte array encontrado com contéudo em string
                    temp = splitedResult[index].toString() 
                    break
                  }
                }
        
                //e pega o token do usuário 
                productName = temp.substr(2, 6)
                expect(productName).to.equals(product.name);
        
                done();

            });
    });
});
