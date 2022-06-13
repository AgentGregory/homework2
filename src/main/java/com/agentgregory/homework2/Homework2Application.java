package com.agentgregory.homework2;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.repository.FileNodeRepository;
import com.agentgregory.homework2.repository.FileNodeRepositoryService;
import com.agentgregory.homework2.service.FileComputer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@RequiredArgsConstructor
public class Homework2Application implements CommandLineRunner {

    private final FileNodeRepositoryService fileNodeRepositoryService;
    private final FileComputer fileComputer;

    public static void main(String[] args) {
        SpringApplication.run(
                Homework2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String root = "C:\\123";
        FileNode resultFileNode = fileComputer.searchFileNode(new File(root), 0L);
        fileNodeRepositoryService.save(resultFileNode);
        System.out.println(fileNodeRepositoryService.constructPath("1.txt", root));
    }
}
