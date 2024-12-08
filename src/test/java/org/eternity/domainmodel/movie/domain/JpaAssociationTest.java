package org.eternity.domainmodel.movie.domain;

import jakarta.persistence.EntityManager;
import org.eternity.domainmodel.generic.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest(showSql = false)
public class JpaAssociationTest {
	@Autowired
	private EntityManager em;

	@Test
	public void persist_and_update() {
		Movie movie = new Movie("한산", 120, Money.wons(10000));
		movie.addScreening(new Screening(1, LocalDateTime.of(2024, 12, 9, 9, 0)));
		movie.addScreening(new Screening(2, LocalDateTime.of(2024, 12, 9, 11, 0)));

		em.persist(movie);
		em.flush();
	}
}