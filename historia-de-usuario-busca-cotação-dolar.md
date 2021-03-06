{\rtf1\ansi\ansicpg1252\deff0\nouicompat\deflang1046{\fonttbl{\f0\fnil\fcharset0 Calibri;}}
{\colortbl ;\red0\green0\blue255;}
{\*\generator Riched20 10.0.18362}\viewkind4\uc1 
\pard\ri-358\sa200\sl276\slmult1\b\f0\fs22\lang22 API de busca de cota\'e7\'e3o do d\'f3lar numa determinada data especificada na requisi\'e7\'e3o\par
\par
Especific\'e7\'e3o\par
\b0 Eu, como usu\'e1rio, desejo acessar a cota\'e7\'e3o do d\'f3lar, numa determinada data, utilizando um endpoint do \b Banco Central do Brasil\b0 , sendo que minha \b API\b0  dever\'e1 gravar os dados coletados numa banco de dados para futura exposi\'e7\'e3o via Rest.\par
\b Dados no Banco\par

\pard\li720\ri-358\sa200\sl276\slmult1\b0  - id da requisi\'e7\'e3o\par
 - timestamp da requisi\'e7\'e3o\par
 - Data da cota\'e7\'e3o do dolar\par
  - Cota\'e7\'e3o de compra\par
  - Cota\'e7\'e3o de venda\par
  - Data e Hora da Cota\'e7\'e3o\par

\pard\ri-358\sa200\sl276\slmult1\b ENDPOINT Busca dos Dados:\par
{\b0{\field{\*\fldinst{HYPERLINK https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios }}{\fldrslt{https://dadosabertos.bcb.gov.br/dataset/dolar-americano-usd-todos-os-boletins-diarios\ul0\cf0}}}}\b0\f0\fs22\par
\b Crit\'e9rios de Aceita\'e7\'e3o\par
       Crit\'e9rio #1 \b0 - API dever\'e1 fornecer um endpoint para busca e coleta dos dados por data;\par
       \b Crit\'e9rio #2 \b0 - API dever\'e1 fornecer um endpoint para busca e coleta dos dados por per\'edodo;\par
       \b Crit\'e9rio #3 \b0 - API documentada no Swagger;\par
        \b Crit\'e9rio #4 \b0 - Monitora\'e7\'e3o com Prometheus e Grafana exibindo m\'e9tricas da API, do DB e da infra;\par
        \b Crit\'e9rio #5 \b0 - Utilizar Tracing (Jaeger);\par
        \b Crit\'e9rio #6 \b0 - Testes automatizados efetivos;\par
                       \b Teste 1 \b0 - Busca por data pela API atrav\'e9s de endpoint Rest e Grava\'e7\'e3o em Banco:\par
                                  - Usuario acessa o endpoint de busca e fornece a data, dados s\'e3o expostos em formato JSon e Gravados no Banco; \par
                                          \b Correto\b0 : Dados s\'e3o expostos em Json;\b\par
                                          Erro\b0 : API retorna MSG de erro amigavel em formato JSon;\b\par
                       Teste 2 \b0 - Busca no banco dos dados gravados atrav\'e9s de endpoint Rest:\par
                                  - Usuario acessa o endpoint de busca e fornece a data, sistema busca no Banco, dados s\'e3o expostos em JSON;\b\par
                                          Correto\b0 : Dados s\'e3o expostos em Json;\par
                                          \b Erro\b0 : API retorna MSG de erro amigavel em formato JSon;\b\par
        Crit\'e9rio #7 \b0 - Utilizar Docker/Docker compose\par
\b\par
}
 