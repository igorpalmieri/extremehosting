/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.ManyToOne;

/**
 *
 * @author igan
 */
public class Request {
    
    @ManyToOne
    private User owner;
    @ManyToOne
    private House house;
    private boolean approved;
    
}
