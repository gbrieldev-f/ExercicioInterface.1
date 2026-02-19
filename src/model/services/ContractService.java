package model.services;

import model.entities.Contract;
import model.entities.Installments;

import java.time.LocalDate;


public class ContractService {

    PaypalService paypalService = new PaypalService();

    public void processContract(Contract contract, Integer month) {
        for (int i = 0; i < month; i++) {

            LocalDate dueDate = contract.getDate().plusMonths(i + 1);
            Double interest = paypalService.interest(contract.getTotalValue()/month , i+1);
            Double paymentFee = paypalService.paymentFee(interest);

            contract.getInstallments().add(new Installments(dueDate, paymentFee));

        }
    }
}
