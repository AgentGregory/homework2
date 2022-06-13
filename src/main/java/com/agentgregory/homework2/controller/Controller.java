package com.agentgregory.homework2.controller;

import com.agentgregory.homework2.model.FileNode;
import com.agentgregory.homework2.model.FileNodeEntity;
import com.agentgregory.homework2.repository.FileNodeRepository;
import com.agentgregory.homework2.repository.FileNodeRepositoryService;
import com.agentgregory.homework2.service.FileComputer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final FileComputer fileComputer;
    private final FileNodeRepositoryService fileNodeRepositoryService;

    @PostMapping("/localhost/files/fill")
    ResponseEntity<FileComputer> searchFileNode(@RequestBody File rootPath, Long id) {
        fileComputer.searchFileNode(rootPath, id);
        return new ResponseEntity<FileComputer>(HttpStatus.CREATED);
    }

    @GetMapping(" /localhost/files/find?name=")
    ResponseEntity<String> constructPath(@RequestBody String name, String rootPath) {
        final String constructPath = fileNodeRepositoryService.constructPath(name, rootPath);
        return new ResponseEntity<> (constructPath, HttpStatus.OK);
    }
}
