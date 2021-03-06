package model;

import helpers.Consts;
import helpers.UtilityClass;

import java.time.LocalDate;

/**
 * Created by brian on 28/11/16.
 */
public class CreditCard {

    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String cardType;
    private String cardNumber;
    private LocalDate expiryDate;
    private String ccvNumber;


    public CreditCard(){}


    public CreditCard(String name, String address1, String address2, String address3, String cardType, String cardNumber,
                      LocalDate expiryDate, String ccvNumber ) {
        setName(name);
        setAddress1(address1);
        setAddress2(address2);
        setAddress3(address3);
        setCardType(cardType);
        setCardNumber(cardNumber);
        setExpiryDate(expiryDate);
        setCCVNumber(ccvNumber);
    }


    public boolean validateName(String input) {
        if(input != null) {
            if (input.matches(Consts.VALID_NAME)) {
                return true;
            }
        }
        return false;
    }


    // validate of Credit Card using the Luhn algorithm
    public boolean validateCreditCardNumber(String inputCCNum) {
        boolean isValid = false;
        int total = 0;
        int ccNumber = 0;

        for (int i = 0; i < inputCCNum.length(); i++) {

            ccNumber = Integer.parseInt(inputCCNum.substring(i, i + 1));

            if (i % 2 == 0) {

                ccNumber = ccNumber * 2;
                if (ccNumber > 9) {
                    ccNumber -= 9;
                }
            }
            total += ccNumber;
        }
        if (total % 10 == 0) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }


    public String validateCCVNumber(String inputCCV) {
        // is numeric and 3 digits in length
        String validCCVInt = "[0-9]{3}";
        if(inputCCV != null) {
            if (!inputCCV.matches(validCCVInt)) {
                UtilityClass.errorMessageCreditCardCCVNumber();
            }
        }
        return inputCCV;
    }


    public void setName(String name) {
        this.name = name;
        validateName(name);
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardNumber(String cardNumber) {
        validateCreditCardNumber(cardNumber);
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCCVNumber(String ccvNumber) {
        validateCCVNumber(ccvNumber);
        this.ccvNumber = ccvNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCcvNumber() {
        return ccvNumber;
    }

    public void setCcvNumber(String ccvNumber) {
        this.ccvNumber = ccvNumber;
    }
    

    @Override
    public String toString() {
        return "model.CreditCard{" +
                "name='" + name + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNumber=" + cardNumber +
                ", expiryDate=" + expiryDate +
                ", cardCCVNumber=" + ccvNumber +
                '}';
    }
}
