package ch.zhaw.CineSearch.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesRepository extends JpaRepository<Times, Long> {
    public List<Times> findByMovie(Movie movie);
}
