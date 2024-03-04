CREATE TABLE IF NOT EXISTS MOVIE (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    release_year INTEGER NOT NULL,
    url VARCHAR(255) NOT NULL,
    votes INTEGER NOT NULL
    );
-- Películas del 2022
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 1 (2022)', 2022, 'https://example.com/image1.jpg', 10);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 2 (2022)', 2022, 'https://example.com/image2.jpg', 5);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 3 (2022)', 2022, 'https://example.com/image3.jpg', 15);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 4 (2022)', 2022, 'https://example.com/image4.jpg', 20);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 5 (2022)', 2022, 'https://example.com/image5.jpg', 8);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 6 (2022)', 2022, 'https://example.com/image6.jpg', 12);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 7 (2022)', 2022, 'https://example.com/image7.jpg', 7);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 8 (2022)', 2022, 'https://example.com/image8.jpg', 18);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 9 (2022)', 2022, 'https://example.com/image9.jpg', 14);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 10 (2022)', 2022, 'https://example.com/image10.jpg', 11);

-- Películas del 2023
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 1 (2023)', 2023, 'https://example.com/image11.jpg', 16);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 2 (2023)', 2023, 'https://example.com/image12.jpg', 9);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 3 (2023)', 2023, 'https://example.com/image13.jpg', 22);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 4 (2023)', 2023, 'https://example.com/image14.jpg', 13);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 5 (2023)', 2023, 'https://example.com/image15.jpg', 17);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 6 (2023)', 2023, 'https://example.com/image16.jpg', 19);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 7 (2023)', 2023, 'https://example.com/image17.jpg', 6);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 8 (2023)', 2023, 'https://example.com/image18.jpg', 10);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 9 (2023)', 2023, 'https://example.com/image19.jpg', 23);
INSERT INTO movie (title, release_year, url, votes) VALUES ('Película 10 (2023)', 2023, 'https://example.com/image20.jpg', 14);