package me.projekat.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.projekat.model.Telefon;

@Dependent
public class TelefonService {

    @Inject
    private EntityManager em;

    @Transactional
    public Telefon createTelefon(Telefon telefon) {
        return em.merge(telefon);
    }

    @Transactional
    public Telefon updateTelefon(Telefon telefon) {
        return em.merge(telefon);
    }

    @Transactional
    public void deleteTelefon(Long telefonId) {
        Telefon telefon = em.find(Telefon.class, telefonId);
        if (telefon != null) {
            em.remove(telefon);
        }
    }

    public Telefon getTelefonById(Long telefonId) {
        return em.find(Telefon.class, telefonId);
    }
}
