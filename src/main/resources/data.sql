USE coffee_shop;

INSERT INTO `users` (`first_name`, `last_name`, `email`,`password`,`address`,`phone_number`,`birth_date`,`status`)
VALUES 
	('Dorin','Gavrila','dorin-gavrila@gmail.com','pass','Romania, Bucuresti, Strada Gabroveni, 030089','+40721058124','2001-02-02','pending'),
    ('Cristobal','Tudor','cristobal.tudor@yahoo.com','pass','Romania, Voluntari, Bulevardul Pipera 1, 077190','+40212006464','2001-02-02','pending'),
    ('Antim','Stoian','antim.stoian@gmail.com','pass','Romania, Timisoara, Strada Eugeniu de Savoya, 300085','+40372705084','2001-02-02','pending'),
    ('Alma','Cretu','alma_cretu@hotmail.com','pass','Romania, Oradea, Strada Motilor, 410089','+40771692320','2001-02-02','pending'),
    ('Emanuel','Cornea','emanuel.cornea@gmail.com','pass','Romania, Cluj-Napoca, Strada Emile Zola, 400112','+40727779607','2001-02-02','blocked'),
    ('Stana','Craciun','stana-craciun@gmail.com','pass','Romania, Timisoara, Bd. Vasile Parvan, Nr. 1-3, 300323','+40735444200','2001-02-02','blocked'),
    ('Edward','Butler','edward.butler@gmail.com','pass','United Kingdom, Rye, 96 High St, TN31 7JN','+441797229003','2001-02-02','blocked'),
    ('Loni','Weis','loni.weis@gmail.com','pass','Germany, Dresden, Sophienstrasse, 01067','+4935149142000','2001-02-02','active'),
    ('Naomi','Bell','naomi-bell@yahoo.com','pass','United Kingdom, Grange-over-Sands, Ayside, LA11 6JA','+441539531475','2001-02-02','active'),
    ('Karl-Wilhelm','Horn','karl-horn@gmail.com','$2a$12$Y0uo2J7GBYu.ufZ3NJmwzewEiuOjGrhUX98alSLTAkC6w3S9aIgnK','Germany, Hamburg, Grosse Elbstrasse 132, 22767','+4940306220','2001-02-02','active');
  
INSERT INTO `categories` (`id`, `name`, `alias`, `parent_id`) 
VALUES 
	('1', 'Cafea', 'cafea', null),
	('2', 'Ceai', 'ceai', null),
    ('3', 'Aparate', 'aparate', null),
    ('4', 'Cafea Boabe', 'cafea-boabe', '1'),
    ('5', 'Aparate Cafea Boabe', 'aparate-cafea-boabe', '3'),
    ('6', 'Cafea Macinata', 'cafea-macinata', '1'),
    ('7', 'Aparate Capsule', 'aparate-capsule', '3'),
    ('8', 'Ceai Infuzabil', 'ceai-infuzabil', '2'),
    ('9', 'Aparate Cafea Macinata', 'aparate-cafea-macinata', '3');

INSERT INTO `products` (`name`, `alias`, `description`, `brand`, `price`, `stock`, `enabled`, `category_id`) 
VALUES 
	('Morra Origini Brasilia Santos Strictly Soft Fine Cup, cafea proaspat prajita 1kg', 'morra-origini-brasilia-santos-strictly-soft-fine-cup-cafea-proaspat-prajita-1kg', 'Morra Origini Brasilia Santos SSFC\n\nBoabele de cafea din regiunea Santos, Brasil, oferă o varietate plăcută de note de gust, perfectă pentru tipuri de preparare de la cafea de filtru la espresso. Dacă sunteți în căutarea unei cafele cu conținut scăzut în aciditate, Brasil Santos este perfectă. Veți savura o cafea dulce, fină, cu aciditate medie, note de nuci și aromă de ciocolată.\n\nBoabele verzi de cafea sunt prăjite de către echipa Morra Origini pentru dumneavoastră astfel încât aromele originale să fie păstrate și evidențiate pentru a oferi experiența unei cafele de specialitate proaspăt prăjită de cea mai bună calitate.', 'Morra', 78.39, 100, 1, 4),
    ('Lavazza Super Crema cafea boabe 1kg', 'lavazza-super-crema-cafea-boabe-1kg', 'Cafeaua Lavazza Super Crema Espresso este un amestec de cafea cu aromă de alune de padure si zahar brun, cu o cremă catifelată și consistentă, împreună creând un espresso ușor și cremos.  Această cafea este recomandată pentru baruri și restaurante.\n\nCafeaua boabe Lavazza Super Crema face parte din colecția Lavazza Classics. Sortimentele de cafea din aceasta gamă sunt cafele pline de eleganță și armonie. Astfel, aromele și gustul sunt perfect echilibrate, caracteristici specifice cafelelor clasice care reprezintă excelența tradiției a espresso-ului Lavazza.\n\nContinut: 60% Arabica- 40% Robusta\n\nDepozitarea trebuie făcută în încăperi curate, uscate și fără mirosuri străine.', 'Lavazza', 58.30, 100, 1, 4),
    ('Pellini Top 100% Arabica cafea boabe 1kg', 'pellini-top-100-arabica-1000g', 'Pellini Top 100% Arabica este cafeaua care te va cuceri cu  aroma consistenta cu un caracter puternic și bogat. Este o cafea boabe perfect prajita cu un gust puternic si o aroma desavarsita ce nu te lasa indiferent. Metoda de prăjire medie și lentă îi conferă acestui amestec un gust armonios și persistent.\n\nDepozitarea trebuie făcută în încăperi curate, uscate și fără mirosuri străine.', 'Pellini', 97.00, 100, 1, 4),
    ('Morra Origini Brasilia Santos Strictly Soft Fine Cup, cafea proaspat prajita, macinata, 250 g', 'morra-origini-brasilia-santos-strictly-soft-fine-cup-cafea-proaspat-prajita-macinata-250-g', 'Morra Origini Brasilia Santos SSFC-cafea macinata din boabe de cafea proaspat prajite.\n\nBoabele de cafea din regiunea Santos, Brasil, oferă o varietate plăcută de note de gust, perfectă pentru tipuri de preparare de la cafea de filtru la espresso. Dacă sunteți în căutarea unei cafele cu conținut scăzut în aciditate, Brasil Santos este perfectă. Veți savura o cafea dulce, fină, cu aciditate medie, note de nuci și aromă de ciocolată.\n\nBoabele verzi de cafea sunt prăjite de către echipa Morra Origini pentru dumneavoastră astfel încât aromele originale să fie păstrate și evidențiate pentru a oferi experiența unei cafele de specialitate proaspăt prăjită de cea mai bună calitate.', 'Morra', 29.80, 100, 1, 6),
    ('Lavazza Qualita Oro Mountain Grown, CUTIE, cafea macinata, 250g', 'lavazza-qualita-oro-mountain-grown-cafea-macinata-cutie-250g', 'Lavazza Qualita Oro Mountain Grown - un amestec unic de cafea din America Centrala, America de Sud si Etiopia, un amestec de cafea 100% Arabica, fructat și aromat cu un caracter semnificativ. Este dedicat adevăraților cunoscători ai specialităților italiene de cafea.\n\nIntensitate :7/10\n\nDepozitarea trebuie făcută în încăperi curate, uscate și fără mirosuri străine.', 'Lavazza', 25.10, 200, 1, 6),
    ('Eilles Tee Assam Special Teebeutel - 25 plicuri', 'eilles-tea-assam-special-teebeutel-25-plicuri', 'Eilles Tee Teebeutel Assam Special  , ceai negru– Un ceai cu o aroma puternica provenit de pe plantatiile din zona Assam (nordul Indiei).\n\nCeaiul este ambalat în pliculețe de hârtie.\n\nEste suficient să turnați apă fierbinte într-un pahar sau cană cu o capacitate de 200-300 ml și să infuzati pentru 3-4 minute plicul de ceai.\n\nCutia contine 25 plicuri x 1.5g.\n\nDepozitarea trebuie făcută în încăperi curate, uscate și fără mirosuri străine la o temperatură maximă de 18°C.', 'Eilles', 13.90, 250, 1, 8),
    ('Ceai GardenFresh Peppermint Tea 25 plicuri', 'gardenfresh-peppermint-tea-25-plicuri', 'Ceai GardenFresh Peppermint Tea 25 plicuri\n\nCeai  de mentă (mentă);\n\n\nInfuzie: 1-3 minute\n\nCeaiul este ambalat în pliculețe de hârtie.\n\nContinut:  25 plicuri  * 1.5 g\nDepozitarea trebuie făcută în încăperi curate, uscate și fără mirosuri străine.', 'GardenFresh', 17.29, 50, 1, 8),
    ('Espressor automat cu rasnita incorporata DIVA DE LUXE', 'espressor-automat-cafea-studio-casa-diva-de-luxe', 'Espressor automat cu rasnita inox incorporata Diva De Luxe, Display LED, Cafea boabe, 1.1 l, 1470 W, 19 Bar, Inox.\n\n \n\nDiva Deluxe este aparatul automat de cafea cu rasnita incorporata, display LED si pompa cu 19 bar presiune, care iti prepara, din boabe proaspat macinate, printr-o simpla atingere One Touch, un espresso perfect italian sau asa cum iti place!  Combinatia perfecta a materialelor de inalta calitate -metal si inox, design-ul  futurist si dimensiunea SLIM de doar 18 cm latime, clasifica superautomatul Diva Deluxe de la Studio Casa in zona de produs de exceptie cu performante ridicate,usor de integrat in orice ambient! Tehnologia din interior asigura aceeasi calitate a cafelei espresso ca cea pregatita la un autentic bar italian. Daca iubesti cafeaua meriti ce este mai bun; Diva Deluxe este companioana diminetilor tale si a momentelor de rasfat!', 'DIVA DE LUXE', 1279.90, 5, 1, 5),
    ('Espressor Francis Francis X7.1 Illy Iperespresso', 'espressor-francis-francis-x71-illy-iperespresso', 'Espressorul Francis Francis X7.1 vă prezintă un design modern si atragator și o tehnologie inovativa care ofera utilizatorului o cafea perfecta.\n\nNoul espressor X7.1 functioneaza doar cu capsulele Iperespresso. Inserati o capsula si datorita sistemului simplu de folosinta, veti obtine un espresso illy direct in ceasca, fara a avea contact cu espressorul, ceea ce se traduce printr-o mentenanta redusa. O atingere simpla pentru o performanta total noua. X7, ultima inovatie a liniei FrancisFrancis! este facut din plastic si metal.\n\nSISTEMUL IPERESPRESSO, este un sistem inchis ce foloseste capsulele illy. Un sistem inovator pentru capsule, creat de catre inventatorul espresso-ului de astazi. Preinfuzia și emulsia garanteaza un produs de calitate superioara: cremos, cu mai multa aroma si la temperatura potrivita. Acest sistem se bazeaza pe folosirea capsulelor illy, capsule ce au o camera de extractie inteligenta care imbunatateste consistenta si gustul cafelei in interiorul ei.\n\nCafeaua curge direct in ceasca, nu exista contact direct cu aparatul, caracteristicile acesteia nefiind in nici un fel influentate.', 'Illy', 858.00, 10, 1, 7),
    ('Morra Origini Yemen Anis, cafea boabe origini, proaspat prajita, 250g', 'morra-origini-yemen-anis-cafea-boabe-origini-proaspat-prajita-250g', 'Yemen Anis-Editie limitata!\n\nRegiunea Anis a devenit o nouă sursă importantă în cultivarea cafelei yemenite în ultimii ani.\n\nAnis oferă cultivatorilor săi de cafea producții ample, având teren fertil, în special în comparație cu sursele tradiționale clasice din Yemen.\n\nPomii de cafea Anis cresc în zona văilor, cuibăriți între munți, precum și pe terasele montane înalte, irigate. Regiunea Anis este o sursă în ascensiune în domeniul cafelei yemenite, cu un mare potential de producție care atrage în mod justificat atenția din ce în ce mai mare din partea lumii cafelei.\n\nCele mai proeminente caracteristici ale profilului de gust ale acestei regiuni sunt notele de ciocolată, fructe uscate, fagure de miere, migdale, note fructate și dezvoltă o aciditate placută.\n\nSortimentul pe care il propunem pentru dumneavoastră vă va incita cu note complexe de miere, lămâiță, citrice și note florale. Veți descoperi o cafea delicată, de intensitate medie, care surprinde și atunci când este băută rece.\n\nBoabele verzi de cafea sunt prăjite de către echipa Morra Origini pentru dumneavoastră astfel încât aromele originale să fie păstrate și evidențiate pentru a oferi experiența unei cafele de specialitate proaspăt prăjită de cea mai bună calitate.', 'Morra ', 61.60, 150, 1, 4);

INSERT INTO `technical_details` (`name`, `value`, `product_id`) 
VALUES 
	('Brand', 'Morra Origini', 1),
	('Gramaj', '1 kg', 1),
	('Continut', 'Cafea', 1),
	('Tip', 'Cafea boabe', 1),
	('Brand', 'Lavazza', 2),
	('Gramaj', '1 kg', 2),
	('Continut', 'Cafea', 2),
	('Tip', 'Cafea boabe', 2),
	('Aroma', 'Delicata', 2),
	('Brand', 'Pellini', 3),
	('Gramaj', '1 kg', 3),
	('Continut', 'Cafea', 3),
	('Tip', 'Cafea boabe', 3),
	('Aroma', 'Intensa', 3),
	('Brand', 'Morra Origini', 4),
	('Gramaj', '250 grame', 4),
	('Continut', 'Cafea', 4),
	('Tip', 'Cafea macinata', 4),
	('Brand', 'Lavazza', 5),
	('Gramaj', '250 grame', 5),
	('Continut', 'Cafea', 5),
	('Tip', 'Cafea macinata', 5),
	('Brand', 'Eilles', 6),
	('Continut', 'Ceai', 6),
	('Tip', 'Ceai infuzabil', 6),
	('Brand', 'GardenFresh', 6),
	('Continut', 'Ceai', 6),
	('Tip', 'Ceai infuzabil', 7),
	('Aroma', 'Menta', 7),
	('Brand', 'DIVA DE LUXE', 8),
	('Alimentare', 'Cafea boabe', 8),
	('Presiune', '19 Bar', 8),
	('Trepte macinare rasnita', '5', 8),
	('Capacitate rezervor apa', '1.1 l', 8),
	('Putere de consum', '1470 W', 8),
	('Brand', 'Illy', 9),
	('Alimentare', 'capsule IPERESPRESSO', 9),
	('Presiune', '15 Bar', 9),
	('Dimensiune', '260 x 250 x 330 mm', 9),
	('Capacitate rezervor apa', '1 l', 9),
	('Putere de consum', '1050 W', 9),
	('Brand', 'Morra Origini', 10),
	('Gramaj', '250 grame', 10),
	('Continut', 'Cafea', 10),
	('Tip', 'Cafea boabe', 10);
    
INSERT INTO `orders` (`total`, `date`, `user_id`)
VALUES
	(293.47, '2022-03-11', 1),
	(58.3, '2022-05-22', 2),
	(97, '2022-01-18', 3),
	(34.58, '2022-04-15', 4),
	(391.95, '2022-05-30', 5),
	(25.1, '2022-05-29', 1);
    
INSERT INTO `order_details` (`quantity`, `unit_price`, `product_id`,`order_id`)
VALUES
	(3,78.39,1,1),
    (1,58.3,2,2),
    (1,97,3,3),
	(5,78.39,1,5),
    (2,17.29,7,4),
    (1,25.1,5,6),
    (1,58.3,2,1);
    
INSERT INTO `cart_items` (`quantity`, `user_id`, `product_id`) 
VALUES 
	('5', '1', '1'),
	('8', '1', '5'),
	('2', '1', '6'),
	('5', '3', '2'),
	('10', '3', '3'),
	('2', '5', '1'),
	('10', '5', '2'),
	('8', '5', '7'),
	('1', '5', '8'),
	('1', '8', '9');