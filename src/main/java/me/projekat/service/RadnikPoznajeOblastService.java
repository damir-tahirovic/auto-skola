package me.projekat.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.projekat.model.Radnik;
import me.projekat.model.RadnikPoznajeOblast;

import java.util.List;

@Dependent
public class RadnikPoznajeOblastService {

    @Inject
    private EntityManager em;

    @Transactional
    public RadnikPoznajeOblast createRadnikPoznajeOblast(RadnikPoznajeOblast veza) {
        return em.merge(veza);
    }

    @Transactional
    public void deleteRadnikPoznajeOblast(Long vezaId) {
        RadnikPoznajeOblast veza = em.find(RadnikPoznajeOblast.class, vezaId);
        if (veza != null) {
            em.remove(veza);
        }
    }

    public RadnikPoznajeOblast getRadnikPoznajeOblastById(Long vezaId) {
        return em.find(RadnikPoznajeOblast.class, vezaId);
    }

    @Transactional
    public List<RadnikPoznajeOblast> getAll() {
        return em.createQuery("SELECT rpo FROM RadnikPoznajeOblast rpo", RadnikPoznajeOblast.class).getResultList();
    }
}
