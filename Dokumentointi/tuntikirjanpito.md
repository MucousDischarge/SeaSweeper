###12.03.2015
Tutustuminen ensimmäisen deadlinen vaatimuksiin. Git tullut tutuksi. Netbeans ei suostu pistämään Coberturaa ja PITtiä valikkoonsa. 2 tuntia käytetty.

###13.03.2015
Netbeans ei suostu edelleenkään pistämään Coberturaa ja PITtiä valikkoonsa. Ilmoitettu molemmille ohjaajille. Toinen vastasi, muttei osannut auttaa. Ohjaaja sanoi Coberturaa voitavan käyttää eräällä toisella tavalla. Pyysin lisää aikaa, sain päivän. 2 tuntia käytetty.

###14.03.2015
Sain todeta, että Coberturaa ja PITtiä ei käytetä vielä tässä vaiheessa. Luulin paljon työtä olevan vielä edessä. Oikeasti ensimmäinen deadline ei vaadi muuta kuin Gittiin tutustumisen. Gittiin olin jo tutustunut eilen. Cobertura ja PIT saatiin korjattua aiemmin vastaamatta jättäneen ohjaajan vastattua. nbactions.xml oli jostain syystä hyvin syvällä Netbeans-projektin sisällä, eikä pom.xml:n vieressä, jossa sen piti olla. Suurin osa ajasta kuitenkin kului siihen, että korjasin fuksiläppärin ongelmia. Kirjoitin aihemäärittelyn ja tuntikirjanpidon. 3 tuntia käytetty.

###20.03.2015
Itse ohjelmoiminen alkaa. Tässä vaiheessa halutaan näköjään jo monta luokkaa ja testiä. Itse näkisin nämä myöhempinä urakoina, sillä jos koko rakenteen tietää jo nyt, niin voisi koko ohjelman jo kasata muutamassa tunnissa. Tein aluksi luokan, joka avaa ikkunan, jossa on monta pientä nappia. Tässä on jo pelin oleellisin koossa. Piti vähän virvoittaa muistia lukemalla ikkunatoiminnoista. Ikkunatestit aiheuttivat haasteita. 10 testiä kuitenkin syntyi, vaikkeivät hyviä ole. En tiedä mitä tarkoittivat Pit-raportilla. Löysin pit-reports-kansion, jossa päivämäärällinen kansio sisällä. Ei se voi olla muu kuin tämä. 4 tuntia käytetty.

###27.03.2015
Tutustuin taas vähän ikkunoiden alkeisiin, ja seuraava selkeä askel on ActionListener. MouseListenerin käyttö tämänkaltaisessa puhtaassa nappiohjelmassa on epäkäytännöllistä. Hassusti käyn lävitse käyttöliittymää ennen itse peliä, vaikka alkusuunnitelmassa suunnittelin päinvastoin. 

Muokkasin luokkia huomattavasti. Pistin kuuntelijan samaan luokkaa kuin lauta, koska piti viitata napistoon, jota en osannut erillisestä luokasta. Sain tämän kikan selville, ja se toimi. Sain toteutettua hiiritestin, joka ei halua toimia. Hiirirobotin kanssa kikkailu kidutusta. Kokeilin streamitestiä, mutta Main jumittui sitä kokeillessa. Tein uuden luokkakaaviokuvan. Pit meni näköjään hulluksi hiirirobotista. 4 tuntia käytetty.

###10.04.2015
Jäsentelin projektia labtoolista löytyneiden ohjeiden mukaisesti, joita en ollut aiemmin huomannut. Loin erilliset alapaketit, ja siistin pom.xml:ää. Poistin vihoitelleen hiiriklikkaustestin... Muokkasin luokkakaavion uuden mukaiseksi - ja olen unohtanut mikä oli aiemmin käyttämäni fontti... Lisäsin uuden logiikkaluokan itse projektiin. Tutustuin Javadocciin, ja luulen tajunneeni idean. Suurin osa ajasta kului pelilogiikkaa luodessa. Olin kirjoittanut sitä aiemmin mukavammalle, isommalle näytölle erilliselle koneelle, ja en nyt kiireessä ehtinyt siistimään että siirtämään ja muovaamaan sopivaksi projektiin. Ei se ole vielä toimivakaan. Tiedän ettei tällä ole mitään merkitystä pisteisiin, mutta ajattelin vain ilmoittaa, ettei huolta. 2 tuntia käytetty.

###18.04.2015
Peli on jo melkein koossa pelilogiikallisesti; jäljellä lähinnä miinoja lähellä olemattomat ruudut ja niiden raivautuminen virusmaisesti, pelin voittaminen ja pelin häviäminen. Sen jälkeen testit ja koodin puhdistus. Sitten myös tietenkin pelivalinnat ja paremmat grafiikat. Jäljellä on kyllä vielä joku harmittava ongelma jossain, joka valittaa välillä jotain ruutua klikatessa exceptionista. Kai se löytyy helposti. 

Toistoa on aika paljon, koska tuli tosiaan taas aika kiire. Se puhdistuu varmasti myös hyvin nopeasti.

--

Miinaluokka oli helpoin pelilogiikan osa, joten aloitin siitä. Sitä luodessani päätin vain generoida satunnaisesti miinat yksinkertaiseen listaan, jossa arvoilla on totuusarvo. Tähän sopi siis erinomaisesti hyvä ystäväni HashMap, jonka ensimmäiseen string-avaimeen voi pistää sijainnin, ja arvoksi booleanin. Käytän stringiä, koska kaksiarvoisten array-arvojen tuonti toisesta luokasta tuotti vaikeuksia. Mahdollisesti tutustun tähän ja muutan täksi. HashMappia ei ollut helppo käydä lävitse satunnaisella numerolla, joten loin ArrayListin, jota voi ja jossa on HashMapin avaimet. En tunne LinkedHashMapia kovin hyvin. Miinat luodaan vasta ensimmäisen klikkauksen jälkeen. En osaa satunnaisjuttuja vielä kovin hyvin, joten kävin hakemassa satunnaisnumeroiden generoijan halutulta väliltä. 

Miinaluokka oli valmis, mutta testaillessani sain todeta HashMapissa olevan vain 250 paria. Tämä johtuu siitä, että esim. 1 14 on sama kuin 11 4. Heitin siis näiden kahden luvun väliin viivan. Helpointa olisi, jos osaisi käyttää tuota kaksiarvoista arrayta. 

Sain tehtyä kuvasysteemin, jolla päästään jo kohta pelaamaan. Jostain syystä ohjelma ei tunnistanut kuin aivan täyttä tiedoston sijaintia tietokoneessa. Mikään /home/:a pienemmästä alkava sijainti ei kelvannut. Kuvat ovat placeholdereita, jotka väänsin hetkessä.

###19.04.2015 00:08
Hups, jäi Raivaaja-metodissa yksinkertaisesti tuplayhtäsuuruusmerkit uupumaan, jolloinka ohjelma ei käy lävitse numeroiden virusmaista leviämistä.

Lisäksi unohdin mainita ajankäytön: 4 tuntia.

###19.04.2015 00:15
Tyhjien ruutujen merkitseminen nollalla, ja tämän lisääminen raivaajaan vei muutaman minuutin... Nyt ongelmana enää lähinnä tuo ärsyttävä exception, joka tapahtuu välillä.
 
###19.04.2015 00:19
Exception-ongelma selvisi hyvin nopeasti. Viittasin ArrayListaani satunnaisella numerolla 1-256, vaikka sen tietenkin pitäisi olla 0-255. 

###19.04.2015 00:58
Korjasin yhden toisen exceptionin, joka johtui -1-, -2-, 16- ja 17-arvoista. Lisäksi huomasin, että nollat eivät leviä tarpeeksi pitkälle. Pitää saada ne olemaan tottelematta leviämättömyyskäskyä.


###19.04.2014 03:59
Korjaan nämä saman päivän päivitykset yhdeksi kokonaisuudeksi myöhemmin. Sain siistittyä koodia aika lailla. Vähän nollat vielä junnaavat supermassiivisissa kööreissä, mutta ratkon sitä myöhemmin...
