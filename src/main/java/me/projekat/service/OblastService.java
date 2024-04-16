package me.projekat.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.projekat.model.Oblast;

import java.util.List;

@Dependent
public class OblastService {

    @Inject
    private EntityManager em;

    @Transactional
    public Oblast createOblast(Oblast oblast) {
        return em.merge(oblast);
    }

    @Transactional
    public Oblast updateOblast(Oblast oblast) {
        return em.merge(oblast);
    }

    @Transactional
    public void deleteOblast(Long oblastId) {
        Oblast oblast = em.find(Oblast.class, oblastId);
        if (oblast != null) {
            em.remove(oblast);
        }
    }

    public Oblast getOblastById(Long oblastId) {
        return em.find(Oblast.class, oblastId);
    }

    @Transactional
    public List<Oblast> getAll() {
        return em.createQuery("SELECT o FROM Oblast o", Oblast.class).getResultList();
    }
}
