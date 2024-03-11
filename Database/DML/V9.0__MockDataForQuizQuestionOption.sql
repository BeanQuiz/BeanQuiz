-- Mock data for Quiz table
INSERT INTO public."Quiz" ("Title", "Description", "TotalQuestions") VALUES
  ('Bean Quiz 1', 'A quiz about various types of beans', 10),
  ('Bean Quiz 2', 'Another quiz about different beans', 15);

-- Mock data for Question table (Quiz 1)
INSERT INTO public."Question" ("QuizID", "Text") VALUES
  (1, 'What is the scientific name for a common bean?'),
  (1, 'Which continent is the origin of kidney beans?'),
  (1, 'How many calories are there in 100 grams of black beans?'),
  (1, 'Which type of bean is used to make hummus?'),
  (1, 'What color are adzuki beans?'),
  (1, 'Which country is the largest producer of soybeans?'),
  (1, 'What is the primary nutrient found in navy beans?'),
  (1, 'Which bean is commonly used in Mexican cuisine?'),
  (1, 'In which dish are pinto beans commonly used?'),
  (1, 'What is the shape of chickpeas?');

-- Mock data for Option table (Quiz 1)
INSERT INTO public."Option" ("QuestionID", "Text", "IsCorrect") VALUES
  (1, 'Phaseolus vulgaris', TRUE),
  (1, 'Vigna unguiculata', FALSE),
  (1, 'Cicer arietinum', FALSE),
  (1, 'Lens culinaris', FALSE),

  (2, 'North America', TRUE),
  (2, 'South America', FALSE),
  (2, 'Africa', FALSE),
  (2, 'Asia', FALSE),

  (3, '348 kcal', FALSE),
  (3, '120 kcal', FALSE),
  (3, '180 kcal', TRUE),
  (3, '250 kcal', FALSE),

  (4, 'Chickpeas', FALSE),
  (4, 'Lentils', FALSE),
  (4, 'Black-eyed peas', FALSE),
  (4, 'Garbanzo beans', TRUE),

  (5, 'Red', TRUE),
  (5, 'Green', FALSE),
  (5, 'Brown', FALSE),
  (5, 'Yellow', FALSE),

  (6, 'United States', FALSE),
  (6, 'Brazil', TRUE),
  (6, 'China', FALSE),
  (6, 'India', FALSE),

  (7, 'Protein', TRUE),
  (7, 'Vitamin C', FALSE),
  (7, 'Fiber', FALSE),
  (7, 'Iron', FALSE),

  (8, 'Kidney beans', FALSE),
  (8, 'Black beans', FALSE),
  (8, 'Pinto beans', TRUE),
  (8, 'Lima beans', FALSE),

  (9, 'Chili con carne', TRUE),
  (9, 'Sushi', FALSE),
  (9, 'Risotto', FALSE),
  (9, 'Pad Thai', FALSE),

  (10, 'Round', FALSE),
  (10, 'Oval', FALSE),
  (10, 'Heart-shaped', FALSE),
  (10, 'Spherical', TRUE);

-- Mock data for Question table (Quiz 2)
INSERT INTO public."Question" ("QuizID", "Text") VALUES
  (2, 'Which bean is known as the "king of beans"?'),
  (2, 'What is the primary ingredient in miso soup?'),
  (2, 'In which region did the fava bean originate?'),
  (2, 'What is the primary use of cannellini beans in Italian cuisine?'),
  (2, 'What is the color of lima beans?'),
  (2, 'Which bean is used to make tempeh?'),
  (2, 'What is the main ingredient in refried beans?'),
  (2, 'Which type of bean is commonly used in Chinese desserts?'),
  (2, 'What is the shape of mung beans?'),
  (2, 'In which dish are butter beans often used?'),
  (2, 'What is the scientific name for garbanzo beans?'),
  (2, 'What is the key ingredient in the Middle Eastern dish falafel?'),
  (2, 'Which bean is the main ingredient in Boston baked beans?'),
  (2, 'What is the primary use of black-eyed peas in Southern cuisine?'),
  (2, 'Which type of bean is commonly used in Japanese sweets?');
  
  -- Mock data for Option table (Quiz 2)
INSERT INTO public."Option" ("QuestionID", "Text", "IsCorrect") VALUES
  (11, 'Lima bean', FALSE),
  (11, 'Kidney bean', FALSE),
  (11, 'Fava bean', TRUE),
  (11, 'Black bean', FALSE),

  (12, 'Tofu', FALSE),
  (12, 'Seaweed', FALSE),
  (12, 'Soybean', TRUE),
  (12, 'Edamame', FALSE),

  (13, 'Mediterranean', FALSE),
  (13, 'South America', FALSE),
  (13, 'Middle East', TRUE),
  (13, 'Asia', FALSE),

  (14, 'Salads', FALSE),
  (14, 'Stews', TRUE),
  (14, 'Pasta', FALSE),
  (14, 'Desserts', FALSE),

  (15, 'Green', FALSE),
  (15, 'White', TRUE),
  (15, 'Purple', FALSE),
  (15, 'Yellow', FALSE),

  (16, 'Garbanzo bean', FALSE),
  (16, 'Black-eyed pea', FALSE),
  (16, 'Adzuki bean', TRUE),
  (16, 'Pinto bean', FALSE),

  (17, 'Hummus', TRUE),
  (17, 'Tabbouleh', FALSE),
  (17, 'Baba ganoush', FALSE),
  (17, 'Falafel', FALSE),

  (18, 'Navy bean', FALSE),
  (18, 'Lentil', FALSE),
  (18, 'Cannellini bean', TRUE),
  (18, 'Black bean', FALSE),

  (19, 'Mung bean', FALSE),
  (19, 'Black bean', FALSE),
  (19, 'Pinto bean', FALSE),
  (19, 'Adzuki bean', TRUE),

  (20, 'Cassoulet', FALSE),
  (20, 'Chili', FALSE),
  (20, 'Minestrone', TRUE),
  (20, 'Ratatouille', FALSE),

  (21, 'Cicer arietinum', FALSE),
  (21, 'Vigna unguiculata', FALSE),
  (21, 'Lens culinaris', FALSE),
  (21, 'Phaseolus vulgaris', TRUE),

  (22, 'Chickpeas', TRUE),
  (22, 'Lentils', FALSE),
  (22, 'Black-eyed peas', FALSE),
  (22, 'Soybeans', FALSE),

  (23, 'Boston baked beans', FALSE),
  (23, 'Chili con carne', TRUE),
  (23, 'Cassoulet', FALSE),
  (23, 'Baked ziti', FALSE),

  (24, 'Southern cuisine', TRUE),
  (24, 'Mediterranean cuisine', FALSE),
  (24, 'Asian cuisine', FALSE),
  (24, 'European cuisine', FALSE),

  (25, 'Anko (sweet red bean paste)', TRUE),
  (25, 'Natto', FALSE),
  (25, 'Edamame', FALSE),
  (25, 'Soy sauce', FALSE);