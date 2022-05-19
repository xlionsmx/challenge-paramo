/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.domain.user;

/**
 *
 * @author lsanmartin
 */
public class UserPremium extends User{

    @Override
    public void setMoney(Double money) {
              
        Double percentage = 0.00;

        if (money > 100) {
               percentage = 1.00;    
        }     
        Double gift = money * percentage;       
        super.setMoney(money + gift);
    }    
}
