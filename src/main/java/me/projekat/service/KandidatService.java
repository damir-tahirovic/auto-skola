package me.projekat.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.projekat.model.Kandidat;

import java.util.List;

@Dependent
public class KandidatService {

@Inject
private EntityManager em;

    @Transactional
    public Kandidat createKandidat(Kandidat kandidat) {
        return em.merge(kandidat);
    }

    @Transactional
    public Kandidat updateKandidat(Kandidat kandidat) {
        return em.merge(kandidat);
    }

    @Transactional
    public void deleteKandidat(Long kandidatId) {
        Kandidat kandidat = em.find(Kandidat.class, kandidatId);
        if (kandidat != null) {
            em.remove(kandidat);
        }
    }

    public Kandidat getKandidatById(Long kandidatId) {
        return em.find(Kandidat.class, kandidatId);
    }
    @Transactional
    public List<Kandidat> getAll(){
    return em.createNamedQuery(Kandidat.GET_ALL, Kandidat.class).getResultList();
    }

}
