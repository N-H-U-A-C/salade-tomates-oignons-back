------------------------------------------------------------
--        Script PostgreSQL (V2)
------------------------------------------------------------



------------------------------------------------------------
-- Table (Entity): animal
------------------------------------------------------------
INSERT INTO animal(animal_id, animal_label) VALUES ('8adcb6de-5db4-42cf-8cf9-056d3b702969', 'Poule');
INSERT INTO animal(animal_id, animal_label) VALUES ('5e05a91f-94f2-4f61-8bd5-3539c6148cc1', 'Bœuf');
INSERT INTO animal(animal_id, animal_label) VALUES ('e0a4c668-4fa8-4eac-a482-9777126b009d', 'Mouton');
INSERT INTO animal(animal_id, animal_label) VALUES ('1424d588-959c-407f-9527-0930710cce77', 'Veau');
INSERT INTO animal(animal_id, animal_label) VALUES ('39adf80f-50da-4af9-bc82-b9a2892822c8', 'Agneau');
INSERT INTO animal(animal_id, animal_label) VALUES ('6c6da8eb-7f4e-4c88-b190-7adf39156de7', 'Porc');
INSERT INTO animal(animal_id, animal_label) VALUES ('84a3d090-98ec-434a-87fb-a63a265ed81f', 'Saumon');
INSERT INTO animal(animal_id, animal_label) VALUES ('1a93aa6c-1d16-49df-a626-f56b7c0e709f', 'Cheval');
INSERT INTO animal(animal_id, animal_label) VALUES ('85166f35-482e-4a56-a8e6-10a779a63dd6', 'Truite');
INSERT INTO animal(animal_id, animal_label) VALUES ('c8a94fc5-311b-4a57-a77f-b85e47460708', 'Dinde');
INSERT INTO animal(animal_id, animal_label) VALUES ('734595b8-a181-4b4c-a067-4c71f838911d', 'Moule');
INSERT INTO animal(animal_id, animal_label) VALUES ('2eb1c5eb-d46e-481f-a18f-c520e8a40248', 'Huître');
INSERT INTO animal(animal_id, animal_label) VALUES ('a0fab814-cea4-4417-9a62-1929fef64a43', 'Bison');
INSERT INTO animal(animal_id, animal_label) VALUES ('23b977a3-b3ba-40c5-ab3d-2af62a2a500f', 'Cerf');
INSERT INTO animal(animal_id, animal_label) VALUES ('7baa2d1d-45f0-48b4-91ab-da8b5a4bb92b', 'Oie');
INSERT INTO animal(animal_id, animal_label) VALUES ('02e875a0-72bf-4f19-8657-4e1d3325fc91', 'Canard');
INSERT INTO animal(animal_id, animal_label) VALUES ('c2f4115f-7c8d-4b71-834f-9cc89205da06', 'Sanglier');
INSERT INTO animal(animal_id, animal_label) VALUES ('722c833b-791b-490d-8a6d-ce5ce755ce19', 'Faisan');
INSERT INTO animal(animal_id, animal_label) VALUES ('ec866d40-86ba-4a54-85da-cd435b4daf00', 'Pintade');
INSERT INTO animal(animal_id, animal_label) VALUES ('ca7597ca-0482-4919-8cfd-74d489805d77', 'Lapin');
INSERT INTO animal(animal_id, animal_label) VALUES ('ec834681-dbc3-400c-b7dd-5387d956f795', 'Grenouille');



------------------------------------------------------------
-- Table (Entity): unit
------------------------------------------------------------
INSERT INTO unit(unit_id, unit_label) VALUES ('886ef1ff-004d-4446-b8b5-37fd9d9e8710', 'g');
INSERT INTO unit(unit_id, unit_label) VALUES ('9da3b02b-f425-47f8-b1f1-ed9504bd38bc', 'kg');
INSERT INTO unit(unit_id, unit_label) VALUES ('77389514-bcb1-4122-9f3d-c96dfba4c7c7', 'l');
INSERT INTO unit(unit_id, unit_label) VALUES ('4909073b-362b-4a1b-96a5-b9c9261cd6a2', 'dl');
INSERT INTO unit(unit_id, unit_label) VALUES ('ce00b854-cd81-4456-8706-6ce75aa8355d', 'cl');
INSERT INTO unit(unit_id, unit_label) VALUES ('c841cd08-4df9-4d48-bab0-6c2f92836a63', 'ml');
INSERT INTO unit(unit_id, unit_label) VALUES ('fb4cda78-65e4-475a-8c14-1ae091340c2b', 'pièce');
INSERT INTO unit(unit_id, unit_label) VALUES ('e7460e70-9011-49c1-9750-9a6d603e78a3', 'unité');
INSERT INTO unit(unit_id, unit_label) VALUES ('f77bc36d-22a7-450a-ab51-74bcf8811b3b', 'cc');
INSERT INTO unit(unit_id, unit_label) VALUES ('67f335af-9496-42e2-92d1-bd5bf86e3305', 'cs');
INSERT INTO unit(unit_id, unit_label) VALUES ('bb278e1b-787e-48fc-b18d-c613970374e8', 'unit1');
INSERT INTO unit(unit_id, unit_label) VALUES ('4f927c94-525c-4a3f-83a1-4424d2cdcb28', 'unit2');
INSERT INTO unit(unit_id, unit_label) VALUES ('f5190df1-d82c-4aab-bc64-1ff27011b55e', 'unit3');
INSERT INTO unit(unit_id, unit_label) VALUES ('9f869cc8-d6d0-47a8-8882-37cefb2e6a8f', 'unit4');
INSERT INTO unit(unit_id, unit_label) VALUES ('7c7114a7-2f49-4b11-8f5f-26ce2a18a7d5', 'unit5');
INSERT INTO unit(unit_id, unit_label) VALUES ('68097cc5-49e3-4532-9eb6-0836679fccc8', 'unit6');
INSERT INTO unit(unit_id, unit_label) VALUES ('5f999be1-9371-4d51-99c2-00edc6516607', 'unit7');
INSERT INTO unit(unit_id, unit_label) VALUES ('e469619a-9128-4f51-858c-d547eec9ea64', 'unit8');
INSERT INTO unit(unit_id, unit_label) VALUES ('df299672-8c0f-4955-b72e-0484fb019764', 'unit9');
INSERT INTO unit(unit_id, unit_label) VALUES ('08f0eacc-6b13-4db3-8df2-1bab445784b2', 'unit10');
INSERT INTO unit(unit_id, unit_label) VALUES ('cf90aab1-7b8b-473f-9d58-01d88e2d7325', 'unit11');



------------------------------------------------------------
-- Table (Entity): ingredient
------------------------------------------------------------
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, unit_id) VALUES ('be561ff3-4342-4af1-849e-f6b948c0667b', 'Beurre', TRUE, FALSE, TRUE, FALSE, 760, '886ef1ff-004d-4446-b8b5-37fd9d9e8710');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('8ba5f755-c7e6-4649-b43f-822983cd473f', 'Ingredient2', false, true, TRUE, true, 500, '84a3d090-98ec-434a-87fb-a63a265ed81f', '9f869cc8-d6d0-47a8-8882-37cefb2e6a8f');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('c013a53f-97d5-40a3-967f-af92782506ac', 'Ingredient3', TRUE, FALSE, false, FALSE, 250, '722c833b-791b-490d-8a6d-ce5ce755ce19', 'ce00b854-cd81-4456-8706-6ce75aa8355d');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('7b544fab-bb77-4632-ae9e-92303d976e6c', 'Ingredient4', TRUE, true, false, FALSE, 10, '84a3d090-98ec-434a-87fb-a63a265ed81f', 'ce00b854-cd81-4456-8706-6ce75aa8355d');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('0bbb18d3-3e71-45a4-a62e-94a8a8e5fb91', 'Ingredient5', false, FALSE, false, true, 110, 'ca7597ca-0482-4919-8cfd-74d489805d77', '886ef1ff-004d-4446-b8b5-37fd9d9e8710');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('f2da3835-7412-45cf-9d16-2c41ec9e2e01', 'Ingredient6', TRUE, FALSE, TRUE, FALSE, 460, '84a3d090-98ec-434a-87fb-a63a265ed81f', '886ef1ff-004d-4446-b8b5-37fd9d9e8710');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('336cbf79-aaf3-4e11-b55c-a898540e628b', 'Ingredient7', false, true, TRUE, true, 420, '84a3d090-98ec-434a-87fb-a63a265ed81f', '886ef1ff-004d-4446-b8b5-37fd9d9e8710');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('ae850e9e-fc21-41f9-9835-5d6deb23e2ab', 'Ingredient8', false, FALSE, TRUE, true, 200, '722c833b-791b-490d-8a6d-ce5ce755ce19', '9f869cc8-d6d0-47a8-8882-37cefb2e6a8f');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('898b9a69-3433-4fc2-b2ca-6b39fa7bcf90', 'Ingredient9', false, FALSE, false, FALSE, 150, '5e05a91f-94f2-4f61-8bd5-3539c6148cc1', 'fb4cda78-65e4-475a-8c14-1ae091340c2b');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('a422f1c5-a117-4bb8-8a1c-68d5c9b3ddeb', 'Ingredient10', TRUE, FALSE, TRUE, true, 210, '1a93aa6c-1d16-49df-a626-f56b7c0e709f', '886ef1ff-004d-4446-b8b5-37fd9d9e8710');
INSERT INTO ingredient(ingredient_id, ingredient_label, vegetarian, vegan, gluten_free, lactose_free, calorie, animal_id, unit_id) VALUES ('38fb323c-cca5-4510-85e0-802f3391fe22', 'Ingredient11', TRUE, true, TRUE, true, 200, 'ec866d40-86ba-4a54-85da-cd435b4daf00', 'fb4cda78-65e4-475a-8c14-1ae091340c2b');



------------------------------------------------------------
-- Table (Entity): account (V2)
------------------------------------------------------------
INSERT INTO account(account_id, username, mail, account_password, avatar) VALUES ('96c2285e-c4e7-4d9f-90d8-ef74b31acd8a', 'User1', 'user1@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'https://duckduckgo.com/i/80f913123c49e2d4.jpg');
INSERT INTO account(account_id, username, mail, account_password, default_serving, avatar) VALUES ('727cf7d4-aff4-4fd6-88a7-e381dbaa81a3', 'User2', 'user2@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 2, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.1vE-YFHyFRET4qSjo0_14AHaG0%26pid%3DApi&f=1&ipt=a640d0186979dc875abe95b3ebe84b33ef1dbc3ac447d9c60e7c4feb713da89e&ipo=images');
INSERT INTO account(account_id, username, mail, account_password, avatar) VALUES ('e3459c78-bdfd-4076-bda9-f2f207709e9c', 'User3', 'user3@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.Equen2ccNpug5PStHT9KagAAAA%26pid%3DApi&f=1&ipt=3684f14e86c0deb1779d7b3d9409055784def872bdfac0bd09769e47e5e772f3&ipo=images');
INSERT INTO account(account_id, username, mail, account_password, account_admin) VALUES ('4a4342a7-ef40-4f1f-8261-2b6072a22c59', 'Admin', 'admin@saladetomatesoignons.com', '5f4dcc3b5aa765d61d8327deb882cf99', TRUE);



------------------------------------------------------------
-- Table (Entity): recipe
------------------------------------------------------------
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('426eecd5-1ab6-453d-ae37-091d43d3e329', 'Recette 1', 'Instruction 1', 5, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('bb2c42da-824e-46e1-af28-76816d903e92', 'Recette 2', 'Instruction 2', 60, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('0a4b8559-c743-40c9-b597-f64481ee7c86', 'Recette 3', 'Instruction 3', 12, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('5539183f-8f41-4cff-9217-ce8f13d31eb3', 'Recette 4', 'Instruction 4', 20, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('61436490-ef70-4acf-ae02-be36b23ffdaf', 'Recette 5', 'Instruction 5', 20, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('a533365b-02eb-41d6-9e85-f4a7b2046c7e', 'Recette 6', 'Instruction 6', 25, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('a9337325-25f1-48d4-9401-a606687d005d', 'Recette 7', 'Instruction 7', 15, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('5b661ccb-60c9-4d2b-8301-5ec6e3334a69', 'Recette 8', 'Instruction 8', 30, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('862b5214-5e1a-4787-a21c-be039c539e24', 'Recette 9', 'Instruction 9', 35, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('c8fe851a-14be-40b7-bba6-96006464e656', 'Recette 10', 'Instruction 10', 25, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('43ae6d13-c70a-4ef2-9ff6-0ac2d3ebd05a', 'Beurre fondu', 'Instruction 11 pour beurre fondu', 1, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');
INSERT INTO recipe(recipe_id, recipe_label, instruction, duration, recipe_public, account_id) VALUES ('06f31463-e0e7-4a6d-81b5-cb97c2b7bddb', 'Recette 12', 'Instruction 12', 12, TRUE, '4a4342a7-ef40-4f1f-8261-2b6072a22c59');



------------------------------------------------------------
-- Table (Relation): filter_ingredient
------------------------------------------------------------
INSERT INTO filter_ingredient(account_id, ingredient_id) VALUES ('96c2285e-c4e7-4d9f-90d8-ef74b31acd8a', '38fb323c-cca5-4510-85e0-802f3391fe22');
INSERT INTO filter_ingredient(account_id, ingredient_id) VALUES ('96c2285e-c4e7-4d9f-90d8-ef74b31acd8a', 'a422f1c5-a117-4bb8-8a1c-68d5c9b3ddeb');



------------------------------------------------------------
-- Table (Relation): add_fridge
------------------------------------------------------------
INSERT INTO add_fridge(account_id, ingredient_id, add_fridge_quantity) VALUES ('96c2285e-c4e7-4d9f-90d8-ef74b31acd8a', 'be561ff3-4342-4af1-849e-f6b948c0667b', 5);
INSERT INTO add_fridge(account_id, ingredient_id, add_fridge_quantity) VALUES ('96c2285e-c4e7-4d9f-90d8-ef74b31acd8a', '8ba5f755-c7e6-4649-b43f-822983cd473f', 3);



------------------------------------------------------------
-- Table (Relation): filter_recipe
------------------------------------------------------------
INSERT INTO filter_recipe(account_id, recipe_id, rating, favorite) VALUES ('727cf7d4-aff4-4fd6-88a7-e381dbaa81a3', '862b5214-5e1a-4787-a21c-be039c539e24', 5, FALSE);
INSERT INTO filter_recipe(account_id, recipe_id, rating, favorite) VALUES ('727cf7d4-aff4-4fd6-88a7-e381dbaa81a3', 'c8fe851a-14be-40b7-bba6-96006464e656', 3, TRUE);



------------------------------------------------------------
-- Table (Relation): compose
------------------------------------------------------------
INSERT INTO compose(recipe_id, ingredient_id, quantity, consumed) VALUES ('862b5214-5e1a-4787-a21c-be039c539e24', '0bbb18d3-3e71-45a4-a62e-94a8a8e5fb91', 5.0, TRUE);
INSERT INTO compose(recipe_id, ingredient_id, quantity, consumed) VALUES ('862b5214-5e1a-4787-a21c-be039c539e24', 'f2da3835-7412-45cf-9d16-2c41ec9e2e01', 7.5, TRUE);
INSERT INTO compose(recipe_id, ingredient_id, quantity, consumed) VALUES ('43ae6d13-c70a-4ef2-9ff6-0ac2d3ebd05a', 'be561ff3-4342-4af1-849e-f6b948c0667b', 10.0, TRUE);
INSERT INTO compose(recipe_id, ingredient_id, quantity, consumed) VALUES ('06f31463-e0e7-4a6d-81b5-cb97c2b7bddb', 'be561ff3-4342-4af1-849e-f6b948c0667b', 20, TRUE);
INSERT INTO compose(recipe_id, ingredient_id, quantity, consumed) VALUES ('06f31463-e0e7-4a6d-81b5-cb97c2b7bddb', '8ba5f755-c7e6-4649-b43f-822983cd473f', 50, TRUE);
