
package com.isaac.session;

import javax.ejb.Local;

/**
 *
 * @author isaac
 */
@Local
public interface CalculaIdadeLocal {
    
   public int CalculaIdade(String nome, int ano);
}
