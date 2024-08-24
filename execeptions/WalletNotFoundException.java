package com.myTask.JavaCode.execeptions;

import com.myTask.JavaCode.execeptions.responces.WalletNotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends WalletException {

    public WalletNotFoundException(UUID walletId) {
        super(new WalletNotFoundResponse("Wallet with id: " + walletId, walletId),HttpStatus.NOT_FOUND);
    }
}
