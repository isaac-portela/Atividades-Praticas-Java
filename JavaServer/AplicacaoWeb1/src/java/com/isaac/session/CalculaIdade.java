
package com.isaac.session;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author isaac
 */
@Stateless
public class CalculaIdade implements CalculaIdadeLocal {

    @Override
    public int CalculaIdade(String nome, int ano) {
        return 2021-ano;
    }
}
