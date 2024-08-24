package com.myTask.JavaCode.State;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum OperationType {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw");

    String type;
}
