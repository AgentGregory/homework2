package com.agentgregory.homework2.repository;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.model.FileNodeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileNodeRepositoryService {

    private final FileNodeRepository fileNodeRepository;

    @Transactional
    public void save(FileNode fileNode) {
        fileNodeRepository.save(new FileNodeEntity(fileNode.getId(), fileNode.getParentId(), fileNode.getName()));
        if (fileNode.getChildren() != null) {
            fileNode.getChildren().forEach(this::save);// рекурсивный вызов save
        }
    }

    @Transactional
    public String constructPath(String name, String rootPath) {
        Optional<FileNodeEntity> searchFileNode = fileNodeRepository.findByName(name);
        if (searchFileNode.isPresent())
            return String.format("%s/%s%s", rootPath, constructPath(searchFileNode.get().getParentId(), ""), searchFileNode.get().getName());
        else
            throw new IllegalArgumentException("Unknown file name");
    }

    private String constructPath(Long id, String path) {
        Optional<FileNodeEntity> fne = fileNodeRepository.findById(id);
        if (fne.isPresent()) {
            return constructPath(fne.get().getParentId(), String.format("%s/%s", fne.get().getName(), path));//рекурсивный constructPath
        } else {
            return path;
        }
    }
}
