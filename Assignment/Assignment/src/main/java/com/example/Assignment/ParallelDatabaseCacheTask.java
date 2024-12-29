package com.example.Assignment;

import java.sql.SQLException;

public class ParallelDatabaseCacheTask implements Runnable {

    private String query;
    private RedisCacheService redisCacheService;

    public ParallelDatabaseCacheTask(String query, RedisCacheService redisCacheService) {
        this.query = query;
        this.redisCacheService = redisCacheService;
    }

    @Override
    public void run() {
        try {
            // Perform MySQL database operation (e.g., select query)
            String dataFromDb = performDatabaseQuery(query);

            // Cache the result in Redis
            redisCacheService.addToCache(query, dataFromDb);

            System.out.println("Database query and cache update completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String performDatabaseQuery(String query) {
        String result = null;
        try {
            result = MySQLCRUD.readRecord(query);  // Read from MySQL using CRUD methods
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
