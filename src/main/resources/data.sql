

INSERT INTO author (author_id, author_name, author_birthdate, author_birthplace, author_nationality, author_biography)
VALUES
(1, 'J.K. Rowling', '1965-07-31', 'Yate, United Kingdom', 'British', 'J.K. Rowling is best known for creating the Harry Potter fantasy series, which has achieved worldwide success.'),
(2, 'George R.R. Martin', '1948-09-20', 'Bayonne, New Jersey, USA', 'American', 'George R.R. Martin is an American novelist and short story writer, best known for A Song of Ice and Fire series.'),
(3, 'Agatha Christie', '1890-09-15', 'Torquay, United Kingdom', 'British', 'Agatha Christie was an English writer known for her detective novels, particularly those featuring Hercule Poirot and Miss Marple.'),
(4, 'Rabindranath Tagore', '1861-05-07', 'Calcutta, India', 'Indian', 'Rabindranath Tagore was a Bengali poet, writer, composer, philosopher, and painter who reshaped Bengali literature and music.'),
(5, 'Haruki Murakami', '1949-01-12', 'Kyoto, Japan', 'Japanese', 'Haruki Murakami is a Japanese writer whose books and stories have been bestsellers in Japan and internationally.'),
(6, 'George Orwell', '1903-06-25', 'Motihari, India', 'British', 'George Orwell was a novelist and journalist best known for "1984" and "Animal Farm", which critique totalitarianism and authoritarian regimes.'),
(7, 'Jane Austen', '1775-12-16', 'Steventon, Hampshire, England', 'British', 'Jane Austen was an English novelist known for her romantic fiction set among the British landed gentry, including "Pride and Prejudice" and "Sense and Sensibility."'),
(8, 'Chinua Achebe', '1930-11-16', 'Ogidi, Nigeria', 'Nigerian', 'Chinua Achebe was a Nigerian novelist and poet, best known for "Things Fall Apart", which is widely regarded as the cornerstone of modern African literature.'),
(9, 'Leo Tolstoy', '1828-09-09', 'Yasnaya Polyana, Russia', 'Russian', 'Leo Tolstoy was a Russian writer famed for his epic novels "War and Peace" and "Anna Karenina", exploring themes of morality, family, and society.'),
(10, 'Isabel Allende', '1942-08-02', 'Lima, Peru', 'Chilean', 'Isabel Allende is a Chilean-American writer whose novels, such as "The House of the Spirits", often include elements of magical realism.');



INSERT INTO publication (publication_id, publication_name, publication_founded, publication_address, publication_website, publication_email, publication_phone)
VALUES
(1, 'Bloomsbury Publishing', '1986-01-01', 'London, United Kingdom', 'https://www.bloomsbury.com', 'contact@bloomsbury.com', '+44 20 7631 5600'),
(2, 'HarperCollins', '1989-01-01', 'New York, USA', 'https://www.harpercollins.com', 'contact@harpercollins.com', '+1 212-207-7000'),
(3, 'Penguin Random House', '2013-07-01', 'New York, USA', 'https://www.penguinrandomhouse.com', 'contact@penguinrandomhouse.com', '+1 212-782-9000'),
(4, 'Macmillan Publishers', '1843-01-01', 'London, United Kingdom', 'https://www.macmillan.com', 'contact@macmillan.com', '+44 20 7014 6000'),
(5, 'Simon & Schuster', '1924-01-01', 'New York, USA', 'https://www.simonandschuster.com', 'contact@simonandschuster.com', '+1 212-698-7000'),
(6, 'Hachette Livre', '1826-01-01', 'Paris, France', 'https://www.hachette.com', 'contact@hachette.com', '+33 1 44 39 90 00'),
(7, 'Scholastic Corporation', '1920-01-01', 'New York, USA', 'https://www.scholastic.com', 'contact@scholastic.com', '+1 212-343-6100'),
(8, 'Random House', '1927-01-01', 'New York, USA', 'https://www.randomhouse.com', 'contact@randomhouse.com', '+1 212-782-9000'),
(9, 'Wiley', '1807-01-01', 'Hoboken, New Jersey, USA', 'https://www.wiley.com', 'contact@wiley.com', '+1 201-748-6000'),
(10, 'Oxford University Press', '1585-01-01', 'Oxford, United Kingdom', 'https://www.oup.com', 'contact@oup.com', '+44 1865 353 501');



INSERT INTO book (book_id, book_name, author_id, book_description, publication_id, published_date) 
VALUES 
(1, 'Harry Potter and the Philosopher''s Stone', 1, 'The first novel in the Harry Potter series follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday.', 1, '1997-06-26'),
(2, 'A Game of Thrones', 2, 'The first novel in A Song of Ice and Fire, the series that inspired HBO''s Game of Thrones.', 2, '1996-08-01'),
(3, 'Murder on the Orient Express', 3, 'Famous Belgian detective Hercule Poirot investigates a murder on the Orient Express train.', 3, '1934-01-01'),
(4, 'Gitanjali', 4, 'A collection of 103 prose poems, selected by Tagore from his Bengali works.', 4, '1910-01-01'),
(5, 'Norwegian Wood', 5, 'A nostalgic story of loss and burgeoning sexuality.', 3, '1987-09-04'),
(6, 'Harry Potter and the Chamber of Secrets', 1, 'The second novel in the Harry Potter series.', 1, '1998-07-02'),
(7, 'A Clash of Kings', 2, 'The second novel in A Song of Ice and Fire series.', 2, '1998-11-16'),
(8, 'Death on the Nile', 3, 'Hercule Poirot investigates a murder during a cruise on the Nile River.', 3, '1937-11-01'),
(9, 'The Home and the World', 4, 'A novel that explores the changing role of women in early 20th century India.', 4, '1916-01-01'),
(10, 'Kafka on the Shore', 5, 'A magical realist novel about a teenage boy and an elderly man whose parallel journeys converge.', 3, '2002-09-12'),
(11, 'The Great Gatsby', 6, 'A novel about the American dream set in the 1920s, following Jay Gatsby\'s tragic pursuit of love.', 5, '1925-04-10'),
(12, '1984', 7, 'A dystopian novel set in a totalitarian society governed by the Party and its leader, Big Brother.', 6, '1949-06-08'),
(13, 'To Kill a Mockingbird', 8, 'A novel about racial injustice in the Deep South, seen through the eyes of young Scout Finch.', 7, '1960-07-11'),
(14, 'Pride and Prejudice', 9, 'A romantic novel about Elizabeth Bennet and her developing relationship with the enigmatic Mr. Darcy.', 8, '1813-01-28'),
(15, 'The Catcher in the Rye', 10, 'A novel about a teenager named Holden Caulfield, exploring the challenges of adolescence and alienation.', 9, '1951-07-16'),
(16, 'The Hobbit', 1, 'A prequel to The Lord of the Rings, following Bilbo Baggins on an adventure to reclaim treasure from a dragon.', 10, '1937-09-21'),
(17, 'Brave New World', 2, 'A dystopian novel about a society that has achieved apparent stability through extreme control and genetic engineering.', 6, '1932-01-01'),
(18, 'The Lord of the Rings: The Fellowship of the Ring', 1, 'The first book in the Lord of the Rings trilogy, beginning the epic quest to destroy the One Ring.', 10, '1954-07-29'),
(19, 'The Shining', 3, 'A horror novel about a man who descends into madness while serving as the caretaker of an isolated hotel.', 4, '1977-01-28'),
(20, 'The Diary of a Young Girl', 4, 'The wartime diaries of Anne Frank, a Jewish girl hiding from the Nazis in World War II.', 5, '1947-06-25');


INSERT INTO review (book_id, review_id, title, description, rating) 
VALUES 
(1, 1, 'Magical Start to a Wonderful Series', 'This book introduces us to the magical world of Harry Potter in an enchanting way. The characters are memorable and the plot is engaging.', 5),
(1, 2, 'Classic Children''s Literature', 'A must-read for all ages. The beginning of an epic journey.', 5),
(1, 3, 'Good but Overrated', 'While it''s a good story, I think it''s somewhat overhyped.', 3),
(2, 1, 'Complex and Engaging', 'The political intrigue and character development are outstanding. Martin creates a rich world.', 5),
(2, 2, 'Too Many Characters', 'While the story is good, keeping track of all the characters is exhausting.', 3),
(3, 1, 'Christie at Her Best', 'One of the most ingenious mystery plots ever written.', 5),
(3, 2, 'Classic Mystery', 'The twist at the end is still shocking even today.', 5),
(4, 1, 'Profound and Soulful', 'Tagore''s poetry speaks to the soul with its deep emotional resonance.', 5),
(4, 2, 'Beautifully Written', 'A collection that captures the spiritual essence of life and love.', 4),
(5, 1, 'Beautifully Written', 'Murakami''s prose is beautiful and the story is deeply moving.', 4),
(5, 2, 'Melancholic Masterpiece', 'A story of loss, love and growing up that stays with you.', 5),
(6, 1, 'Great Sequel', 'An excellent continuation of the Harry Potter series, with even more magical adventures.', 5),
(6, 2, 'Not as Good as the First', 'It''s a good book, but doesn''t quite live up to the magic of the first one.', 4),
(7, 1, 'Epic Fantasy', 'The political intrigue and battles are even more intense in this book. A must-read for fantasy fans.', 5),
(7, 2, 'Too Much Politics', 'While the story is compelling, there are too many political subplots for my liking.', 3),
(8, 1, 'Masterful Mystery', 'A classic Hercule Poirot mystery that keeps you guessing till the very end.', 5),
(8, 2, 'Predictable Ending', 'The book was good, but the ending was easy to guess.', 3),
(9, 1, 'A Deep Exploration of Change', 'Tagore''s story of personal and social change in India is thought-provoking and well-written.', 5),
(9, 2, 'Good but Slow', 'While the themes are great, the pacing of the novel felt a bit slow for me.', 3),
(10, 1, 'A Magical Journey', 'A beautifully crafted novel that combines the surreal with the deeply emotional.', 5),
(10, 2, 'Confusing but Beautiful', 'The narrative is puzzling at times, but the beauty of the writing makes it worthwhile.', 4),
(11, 1, 'A Tragic Story of Love and Wealth', 'A story that captures the excess and the emptiness of the American dream in the Jazz Age.', 5),
(11, 2, 'Overhyped', 'While a classic, I feel like the book didn''t live up to its reputation.', 3),
(12, 1, 'A Chilling Dystopia', 'Orwell''s vision of a totalitarian future is chillingly relevant today.', 5),
(12, 2, 'Hard to Read', 'The book is incredibly bleak, and the themes are a bit too heavy for me.', 4),
(13, 1, 'Powerful and Moving', 'A story of racial injustice that tugs at your heart and makes you think deeply.', 5),
(13, 2, 'Overrated', 'The novel is good, but I don''t think it''s as groundbreaking as people say.', 3),
(14, 1, 'A Timeless Love Story', 'A classic romance that is still relevant today, with sharp wit and clever dialogue.', 5),
(14, 2, 'Slow at Times', 'While a great story, some parts of the book feel slow and repetitive.', 4),
(15, 1, 'A Deep Exploration of Teenage Struggles', 'Holden Caulfield is one of the most complex literary characters I''ve ever read about.', 5),
(15, 2, 'Annoying Protagonist', 'While the book has value, I found Holden to be an incredibly frustrating character.', 3),
(16, 1, 'A Wonderful Adventure', 'An exciting and charming prequel to The Lord of the Rings. A must-read for fantasy lovers.', 5),
(16, 2, 'Too Simple', 'It felt a bit too simple compared to other epic fantasies, but still enjoyable.', 4),
(17, 1, 'An Eerily Prescient Novel', 'Huxley''s vision of a dystopian future feels alarmingly close to reality.', 5),
(17, 2, 'Interesting but Depressing', 'While thought-provoking, the book''s bleak view of society can be overwhelming.', 4),
(18, 1, 'An Epic Beginning', 'A brilliant start to an epic fantasy journey, with unforgettable characters and a rich world.', 5),
(18, 2, 'Slow Start', 'The beginning was slow and a bit hard to get through, but the payoff is worth it.', 4),
(19, 1, 'King at His Best', 'A terrifying and psychologically intense novel that grabs you from the first page.', 5),
(19, 2, 'Not Scary Enough', 'While a good story, I didn''t find it as scary as I expected from King.', 4),
(20, 1, 'A Heartbreaking and Powerful Account', 'Anne Frank''s diary is a powerful reminder of the horrors of war and the strength of the human spirit.', 5);
