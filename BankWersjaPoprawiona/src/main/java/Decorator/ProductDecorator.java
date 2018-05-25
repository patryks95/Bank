package Decorator;

import Interest.Interest;
import Products.Account;

public class ProductDecorator  extends Account {
    ProductDecorator(Interest interest, int ID, int AccountID) {
        super(interest, ID, AccountID);
    }
}
