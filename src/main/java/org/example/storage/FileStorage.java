package org.example.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileStorage {
    private final File file = new File("target/tasks.json");

    public void save(List<Task> task) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.writeValue(file,task);
    }

    public List<Task> load(){
        try {
            if (!file.exists()) {
                return new ArrayList<>();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            System.out.println("Не удалось загрузить задачи, начнём с пустого списка.");
            return new ArrayList<>();
        }
    }
}
