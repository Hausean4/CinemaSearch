package ch.zhaw.CineSearch.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
        public Optional<Movie> findByMovieName(String movieName);
    }