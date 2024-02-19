package com.iescierva;

import com.github.javafaker.Faker;
import com.iescierva.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

public class examenTest {

    private static Faker faker = new Faker();

    @Test
    void insertDataTest() {
        insertData();
    }

    private void insertData() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            for (int i = 0; i < 10; i++) {
                Mecanico mecanico = new Mecanico(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(), faker.number().randomDouble(2,1000, 2000), faker.random().nextBoolean() ? "Mañana" : "Tarde");
                session.persist(mecanico);
            }

            for (int i = 0; i < 10; i++) {
                Propietario propietario = new Propietario(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(),faker.phoneNumber().cellPhone());
                session.persist(propietario);
            }

            for (int i = 0; i < 10; i++) {
                Piloto piloto = new Piloto(faker.number().digits(12), faker.name().fullName(), faker.address().fullAddress(), faker.number().digits(8));
                session.persist(piloto);
            }

            for (int i = 0; i < 10; i++) {
                Tipo tipo = new Tipo(faker.letterify("????"), faker.number().numberBetween(100, 300), faker.number().randomDouble(2,10000, 50000));
                session.persist(tipo);
            }

            for (int i = 0; i < 10; i++) {
                Hangar hangar = new Hangar(faker.letterify("????"), faker.number().numberBetween(0, 10), faker.address().cityName());
                session.persist(hangar);
            }

            Set<Hangar> hangares = new HashSet<>(session.createQuery("from Hangar", Hangar.class).getResultList());

            for (int i = 0; i < 100; i++) {
                Avion avion = new Avion(faker.number().digits(6), faker.letterify("???-###"), faker.date().birthday(1, 5), faker.date().birthday(2, 10), hangares.
                session.persist(avion);
            }

            session.getTransaction().commit();
        }

    }
}
