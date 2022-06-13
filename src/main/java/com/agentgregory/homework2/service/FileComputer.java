package com.agentgregory.homework2.service;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.service.IdComputer;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileComputer {

    private Long counter = 0L;
    private final IdComputer computer = (id) -> counter += 1;

    public FileNode searchFileNode(File rootPath, Long id) {
        Long count1 = computer.compute(id);
        if (rootPath.exists() && rootPath.isDirectory()) {
            Stream<File> children = Arrays.stream(rootPath.listFiles());
            return new FileNode(
                    count1,
                    id,
                    rootPath.getName(),
                    children
                            .map(child -> {
                                Long count2 = computer.compute(computer.compute(id));
                                return new FileNode(
                                        count2,
                                        count1,
                                        child.getName(),
                                        (child.isDirectory())
                                                ? Arrays.stream(child.listFiles())
                                                .map(childChild -> searchFileNode(childChild, count2))
                                                .collect(Collectors.toList())
                                                : null
                                );
                            })
                            .collect(Collectors.toList())
            );
        }
        return new FileNode(count1, id, rootPath.getName(), null);
    }
}
