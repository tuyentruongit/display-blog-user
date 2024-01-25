package web.movie.web1;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import web.movie.web1.entity.Blog;
import web.movie.web1.entity.User;
import web.movie.web1.model.Role;
import web.movie.web1.repository.BlogRepository;
import web.movie.web1.repository.MovieRepository;
import web.movie.web1.entity.Movie;
import web.movie.web1.model.MovieType;
import web.movie.web1.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class Web1ApplicationTests {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;



    @Test
    void contextLoads() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            String title = faker.book().title();
            Boolean status = faker.bool().bool();
            Date createAt = faker.date().birthday();
            Date publishAt = null;
            if (status){
                publishAt = createAt;
            }

            Movie movie = Movie.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .poster(faker.company().logo())
                    .relishYear(faker.number().numberBetween(2020,2024))
                    .view(faker.number().numberBetween(1000,10000))
                    .rating(faker.number().randomDouble(1,6,10))
                    .movieType(MovieType.values()[random.nextInt(MovieType.values().length)])
                    .status(status)
                    .createAt(createAt)
                    .updateAt(createAt)
                    .publishedAt(publishAt)
                    .build();
            movieRepository.save(movie);
        }



    }
    @Test
    void createDataUser(){
        Faker faker = new Faker();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Date createAt = faker.date().birthday();
            User user = User.builder()
                    .name(faker.name().name())
                    .email(faker.internet().emailAddress())
                    .password(faker.internet().password())
                    .avatar(faker.company().logo())
                    .role(Role.values()[random.nextInt(Role.values().length)])
                    .createAt(createAt)
                    .updateAt(createAt)
                    .build();
            userRepository.save(user);
        }
    }
    @Test
    void createDataBlog(){
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        List<User> listAdmin = userRepository.findByRole(Role.ROLE_ADMIN);
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(listAdmin.size());
            User user = listAdmin.get(index);
            String title = faker.book().title();
            Boolean status = faker.bool().bool();
            Date createAt = faker.date().birthday();
            Date publishAt = null;
            if (status){
                publishAt = createAt;
            }
            Blog blog = Blog.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .content(faker.lorem().paragraph(30))
                    .thumBail(faker.company().logo())
                    .status(status)
                    .createAt(createAt)
                    .updateAt(createAt)
                    .publishedAt(publishAt)
                    .user(user)
                    .build();
            blogRepository.save(blog);
        }
    }

}
