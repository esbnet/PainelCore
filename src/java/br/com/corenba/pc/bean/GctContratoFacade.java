/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corenba.pc.bean;

import br.com.corenba.pc.model.GctContrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edmilson
 */
@Stateless
public class GctContratoFacade extends AbstractFacade<GctContrato> {

    @PersistenceContext(unitName = "PainelCorenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GctContratoFacade() {
        super(GctContrato.class);
    }
    
}
