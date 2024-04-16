package me.projekat.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.projekat.model.Radnik;

import java.util.List;

@Dependent
public class RadnikService {

    @Inject
    private EntityManager em;

    @Transactional
    public Radnik createRadnik(Radnik radnik) {
        return em.merge(radnik);
    }

    @Transactional
    public Radnik updateRadnik(Radnik radnik) {
        return em.merge(radnik);
    }

    @Transactional
    public void deleteRadnik(Long radnikId) {
        Radnik radnik = em.find(Radnik.class, radnikId);
        if (radnik != null) {
            em.remove(radnik);
        }
    }

    public Radnik getRadnikById(Long radnikId) {
        return em.find(Radnik.class, radnikId);
    }

    @Transactional
    public List<Radnik> getAll() {
        return em.createQuery("SELECT r FROM Radnik r", Radnik.class).getResultList();
    }
}
