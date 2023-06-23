package com.example.petrescue.dao;


import com.example.petrescue.dto.AnimalDTO;
import com.example.petrescue.models.Dog;
import com.example.petrescue.service.DogsFetcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DogRepo {
    private SessionFactory sessionFactory;

    public DogRepo() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") //
                .build();

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void addDog(@NotNull AnimalDTO dog) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(new Dog(
                    dog.id(),
                    dog.name(),
                    (dog.photos().size() > 0) ? dog.photos().get(0).small() : ""
            ));

            session.getTransaction()
                    .commit();
        }
    }

    public List<AnimalDTO> getDogs() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            List<Dog> dogs = session.createQuery("select d from Dog d", Dog.class)
                    .list();
            List<AnimalDTO> result = new ArrayList<>();

            for (Dog d : dogs) {
                result.add(DogsFetcher.getSingleAnimal(d.getId()));
            }

            session.getTransaction()
                    .commit();
            session.close();

            return result;
        }
    }

    public void removeDog(@NotNull AnimalDTO dog) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Dog toRemove = session.createQuery(
                            String.format("select d from Dog d where d.id = %s", dog.id()), Dog.class)
                    .getSingleResult();

            session.remove(toRemove);

            session.getTransaction()
                    .commit();
        }
    }
}
