/* from Andreas Martin FHNW
https://github.com/DigiPR/digipr-acrm
 */

package com.unchained.Unchained.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {

    @Id
    private String token;

    public Token() {}

    public Token(String token) {
        this.token = token;
    }
}
