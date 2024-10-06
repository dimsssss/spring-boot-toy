package com.dimsss.toy;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class DatabaseClearAfrerAllExtension implements AfterAllCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        SpringExtension.getApplicationContext(extensionContext)
                .getBean(DatabaseCleaner.class)
                .clear();
    }
}
