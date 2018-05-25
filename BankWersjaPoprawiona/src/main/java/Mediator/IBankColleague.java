package Mediator;

import Products.Operation;
import com.sun.xml.internal.ws.client.SenderException;

public interface IBankColleague {


    void Send(Operation operation);
    void Receive(Operation operation);



}
