package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.ShopService;
import core.basesyntax.Storage;
import core.basesyntax.operations.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.execute(storage, transaction);
        }
    }
}
