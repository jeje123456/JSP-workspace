DROP TABLE IF EXISTS members;

CREATE TABLE members (
  `id` INT unsigned NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `phone` varchar(100) default NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Weber","010-2216-9154","dignissim.lacus@naver.com"),
  ("Chavez","010-2013-3317","donec.tempor@naver.com"),
  ("Parker","010-6671-3272","ligula@google.com"),
  ("Delaney","010-8875-6736","mauris.molestie.pharetra@google.com"),
  ("Peck","010-4245-3388","mi.tempor.lorem@naver.com"),
  ("Donovan","010-7436-2858","risus@google.com"),
  ("Dunlap","010-5486-3853","feugiat@naver.com"),
  ("Potter","010-0166-0561","fames.ac.turpis@google.com"),
  ("Delgado","010-5141-6077","eu@naver.com"),
  ("Park","010-2243-0611","nulla.donec@naver.com"),
  ("Hays","010-7243-5533","semper@naver.com"),
  ("Powers","010-7434-6467","et.euismod.et@naver.com"),
  ("Hernandez","010-6510-7822","mauris@naver.com"),
  ("Norris","010-8137-1070","ut.erat@naver.com"),
  ("Mckee","010-9726-8898","amet@naver.com"),
  ("Castillo","010-7064-3021","tempor.arcu@google.com"),
  ("Meadows","010-1156-7583","sagittis.nullam@google.com"),
  ("Payne","010-8269-0683","ullamcorper.magna.sed@google.com"),
  ("Harrison","010-7417-9746","eget@google.com"),
  ("Little","010-4281-5674","scelerisque.mollis@google.com");
INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Hudson","010-8393-4574","augue.eu@naver.com"),
  ("Summers","010-6368-2434","eleifend@naver.com"),
  ("Neal","010-2346-8850","urna.suscipit@naver.com"),
  ("Underwood","010-9542-7194","non@google.com"),
  ("Nixon","010-5387-3956","cum.sociis@naver.com"),
  ("Franks","010-6236-7805","congue.turpis@google.com"),
  ("Duran","010-0384-3185","neque.in@naver.com"),
  ("Guerra","010-9279-5622","aliquam.gravida@naver.com"),
  ("Dudley","010-6707-6812","molestie.arcu@naver.com"),
  ("Browning","010-5124-5758","ac@naver.com"),
  ("Hines","010-5060-9728","massa.vestibulum@google.com"),
  ("Casey","010-5445-4526","volutpat.ornare.facilisis@google.com"),
  ("Sharp","010-7742-9105","tempus@google.com"),
  ("Sweet","010-5714-6148","auctor.nunc.nulla@naver.com"),
  ("Ramos","010-8453-5655","tempus.mauris@google.com"),
  ("Olsen","010-6716-2665","sem.pellentesque@naver.com"),
  ("Giles","010-6852-0369","dictum.proin@naver.com"),
  ("Miles","010-3574-6689","sapien.aenean@naver.com"),
  ("Shepherd","010-2557-7642","sollicitudin.orci@google.com"),
  ("Price","010-2326-5064","ipsum.ac.mi@google.com");
INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Flynn","010-6938-0988","sem@google.com"),
  ("Pitts","010-6657-2739","imperdiet.ornare.in@google.com"),
  ("Black","010-4590-2362","mus.aenean.eget@naver.com"),
  ("Mathews","010-1157-5507","vel@google.com"),
  ("Guerra","010-7449-2312","aliquam.tincidunt@google.com"),
  ("Coffey","010-2104-2674","dolor.vitae@google.com"),
  ("Griffin","010-2650-7174","mattis.cras.eget@naver.com"),
  ("Schultz","010-6147-3354","a.odio@google.com"),
  ("Langley","010-3192-0567","nulla.tempor.augue@google.com"),
  ("Cox","010-5558-2531","et.euismod@naver.com");
INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Olsen","010-5108-3756","facilisis.suspendisse@google.com"),
  ("Macias","010-1206-1547","risus.quis@naver.com"),
  ("Boyd","010-0436-0387","donec.nibh.enim@naver.com"),
  ("Juarez","010-5147-0666","maecenas@naver.com"),
  ("Moore","010-3644-7266","at.augue@naver.com"),
  ("Cote","010-3467-9786","nonummy.ac.feugiat@naver.com"),
  ("Rivers","010-0358-4146","gravida@google.com"),
  ("Rojas","010-7398-3453","mollis.duis@naver.com"),
  ("Emerson","010-2520-1220","enim@naver.com"),
  ("Fleming","010-0295-5937","nisi@naver.com"),
  ("Rhodes","010-3663-6428","proin.vel.arcu@naver.com"),
  ("Duncan","010-3062-2112","ut@naver.com"),
  ("Cooley","010-2331-8338","velit.aliquam.nisl@naver.com"),
  ("Villarreal","010-3516-5301","sed.eget.lacus@google.com"),
  ("Ellis","010-5721-7673","proin.nisl.sem@google.com"),
  ("Carter","010-3814-8191","ligula.aliquam.erat@google.com"),
  ("Bullock","010-2844-5626","sem.consequat@google.com"),
  ("Mcdowell","010-2448-0332","ullamcorper.duis@google.com"),
  ("Small","010-0392-0852","mollis.non@naver.com"),
  ("Harper","010-2418-1875","mauris.integer@google.com");
INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Gay","010-8024-8633","iaculis.lacus@naver.com"),
  ("Conrad","010-2014-6641","phasellus.fermentum.convallis@naver.com"),
  ("Grimes","010-8816-6158","tellus.lorem@google.com"),
  ("Duke","010-1887-4053","ac.orci@naver.com"),
  ("Sharpe","010-6271-7562","placerat.orci.lacus@naver.com"),
  ("Aguilar","010-8403-6165","lorem@google.com"),
  ("Wilkerson","010-7557-7243","felis.purus.ac@naver.com"),
  ("Love","010-7433-1768","sed@google.com"),
  ("Huber","010-4178-3145","penatibus.et.magnis@google.com"),
  ("Wilkinson","010-2003-1291","arcu.curabitur@google.com"),
  ("Mckenzie","010-0168-0552","sed.auctor@naver.com"),
  ("Rutledge","010-6189-6843","augue@google.com"),
  ("Meyers","010-7659-8514","ultrices.posuere@google.com"),
  ("Best","010-8199-7288","non.sollicitudin@naver.com"),
  ("Lawrence","010-7258-4867","dolor.sit@naver.com"),
  ("Hull","010-3564-1350","odio.sagittis.semper@google.com"),
  ("Ruiz","010-7751-2722","ligula.consectetuer.rhoncus@naver.com"),
  ("Alvarez","010-1101-1840","vulputate.posuere@google.com"),
  ("Conley","010-6568-1812","ipsum.dolor@naver.com"),
  ("Porter","010-0806-1598","arcu.vel.quam@naver.com");
INSERT INTO members (`name`,`phone`,`email`)
VALUES
  ("Tran","010-2185-8796","cursus.non@google.com"),
  ("Rivas","010-6826-0799","arcu@google.com"),
  ("Herrera","010-4622-8771","convallis.convallis@naver.com"),
  ("Weiss","010-6263-6336","felis.donec.tempor@naver.com"),
  ("Burke","010-8586-2536","mauris.aliquam@google.com"),
  ("Stout","010-4992-6844","ullamcorper@google.com"),
  ("Barlow","010-4500-1543","facilisis.suspendisse.commodo@google.com"),
  ("Murray","010-4883-8656","in@google.com"),
  ("Mayo","010-8224-4756","urna.et@naver.com"),
  ("Butler","010-8613-2569","risus@naver.com");
