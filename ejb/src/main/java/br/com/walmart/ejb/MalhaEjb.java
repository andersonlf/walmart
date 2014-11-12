package br.com.walmart.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(IMalha.class)
@Remote(IMalha.class)
public class MalhaEjb implements IMalha {

}
