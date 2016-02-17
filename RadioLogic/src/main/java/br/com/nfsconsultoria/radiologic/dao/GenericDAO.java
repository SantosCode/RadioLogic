/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.util.HBUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author luis
 * @param <Entidade>
 */
public class GenericDAO<Entidade> {

    @SuppressWarnings("FieldMayBeFinal")
    private Class<Entidade> classe;

    public GenericDAO() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void salvar(Entidade entidade) {

        Session sessao = HBUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void editar(Entidade entidade) {

        Session sessao = HBUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Entidade entidade) {

        Session sessao = HBUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public List<Entidade> listar() {

        Session sessao = HBUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(classe);
            List<Entidade> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public List<Entidade> listar(String campoOrdenacao) {

        Session sessao = HBUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.addOrder(Order.asc(campoOrdenacao));
            List<Entidade> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public Entidade buscarCodigo(Long codigo) {
        Session sessao = HBUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(codigo));
            Entidade resultado = (Entidade) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }
    public Entidade buscarNome(String nome) {
        Session sessao = HBUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.eq("nome", nome));
            Entidade resultado = (Entidade) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public Entidade merge(Entidade entidade) {

        Session sessao = HBUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            Entidade retorno = (Entidade) sessao.merge(entidade);
            transacao.commit();
            return retorno;
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            sessao.close();
        }
    }
}
