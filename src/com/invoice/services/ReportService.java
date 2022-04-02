package com.invoice.services;

import com.invoice.Item;
import com.invoice.models.Database;

import java.util.Set;

public class ReportService {
    Database database;

    public ReportService(Database database) {
        this.database = database;
    }

    public Set<Item> showAllItems() {
        return database.getItemSet();
    }
}
