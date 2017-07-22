/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corenba.pc.bean;

import br.com.corenba.pc.model.GctPagamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edmilson
 */
@Stateless
public class GctPagamentoFacade extends AbstractFacade<GctPagamento> {

    @PersistenceContext(unitName = "PainelCorenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GctPagamentoFacade() {
        super(GctPagamento.class);
    }
    
}
